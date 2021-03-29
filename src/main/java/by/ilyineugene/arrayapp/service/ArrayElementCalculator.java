package by.ilyineugene.arrayapp.service;

import by.ilyineugene.arrayapp.exception.OperationArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ArrayElementCalculator<T extends Number> {
    static Logger logger = LogManager.getLogger("ConsoleLog");

    public Double calculateAverageValue(T[] array) throws OperationArrayException {
        if (array == null || array.length == 0) {
            throw new OperationArrayException("count error. it is impossible to find the average of 0 elements or array is null");
        } else {
            double sum = 0;
            for (int index = 0; index < array.length; index++) {
                sum += array[index].doubleValue();
            }
            logger.log(Level.DEBUG,"return average value of array");
            return sum / array.length;
        }
            /*
            String typeOfArray = array.getClass().getTypeName();
            switch (typeOfArray) {
                case "Byte":
                    if (sum < -128 || sum > 127) {
                        logger.log(Level.DEBUG, "a byte overflow occurred");
                    }
                    Byte result;
                    int xx = (int) sum / array.length;
                    result = (byte) xx;
                    break;
                case "Char":

            }
            //if( typeOfArray == "Double" || typeOfArray == "Float")
            String str = "test";
        }
        //logger.log(Level.DEBUG, this.getClass().getName() + " : incorrect initial data. array size is 0. return 0");
        */
    }
}
