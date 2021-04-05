package by.ilyineugene.arrayapp.reader;

import by.ilyineugene.arrayapp.exception.OperationArrayException;
import by.ilyineugene.arrayapp.validator.ArrayFileValidator;
import by.ilyineugene.arrayapp.validator.ArrayStringValidator;

import java.io.*;

public class ArrayReader {

    public String fileArrayReader(String filePath) throws OperationArrayException {
        File file = new File(filePath);
        boolean isFoundValidString = false;
        String string="";
        if (ArrayFileValidator.isValid(file)) {
            try {
                FileInputStream fileInputStream = new FileInputStream(filePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                string = br.readLine(); //первая строка точно есть, т.к. файл валидный
                do {

                    isFoundValidString = ArrayStringValidator.isValid(string);
                    if (isFoundValidString) {
                        break; //валидная строка найдена
                    }
                    string = br.readLine();
                } while (string != null);
                br.close();
            } catch (FileNotFoundException e) {
                throw new OperationArrayException("File not found...");
            } catch (IOException e) {
                throw new OperationArrayException("input output exception in buffered reader...");
            }
        }
        if(isFoundValidString){
            return string;
        } else {
            throw new OperationArrayException("there are no valid lines in the file...");
        }
    }
}
