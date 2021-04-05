package by.ilyineugene.arrayapp.validator;

public class ArrayStringValidator {

    public static boolean isValid(String string) {
        boolean isValid = false; //строка невалидна, пока мы не доказали обратное
        if (string != null && string.length() > 0) {
            char[] allowedSeparators = new char[]{' ', '-', ','};
            int stringLength = string.length(); //экономим время цп, чтобы не вызывать метод каждый раз
            int stringIndex = 0;
            while (stringIndex < stringLength) {
                char checkedCharacter = string.charAt(stringIndex); //берем проверяемый символ, экономим время цп, чтобы не вызывать метод каждый раз
                boolean isSeparator = false; //считаем, что не разделитель, пока не доказали обратное
                for (int separatorIndex = 0; separatorIndex < allowedSeparators.length; separatorIndex++) {
                    if (checkedCharacter == allowedSeparators[separatorIndex]) {
                        isSeparator = true; //символ является разделителем
                    }
                }
                isValid = isSeparator || (checkedCharacter >= 48 && checkedCharacter <= 57); //проверяем, является ли символ разрешенным
                if (!isValid) {
                    break; //строка уже невалидна на текущем символе
                }
                stringIndex++;
            }
        }
        return isValid;
    }

}
