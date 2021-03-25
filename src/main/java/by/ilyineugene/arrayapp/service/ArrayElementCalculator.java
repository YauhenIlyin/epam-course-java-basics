package by.ilyineugene.arrayapp.service;

import by.ilyineugene.arrayapp.exception.CountElementsOfArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayElementCalculator <DATA_TYPE extends Number> {
    static Logger logger = LogManager.getLogger("ConsoleLog");

    public Double calculateAverageValue(DATA_TYPE [] array) {
        try {
            if (array.length == 0) {
                //fatal ???????????????????????????
                throw new CountElementsOfArrayException("count error. it is impossible to find the average of 0 elements\n");
            } else {
                double sum = 0;
                for (int index = 0; index < array.length; index++) {
                    sum += array[index].doubleValue();
                }
                logger.log(Level.DEBUG, " return average value of array");
                return sum / array.length;
            }
        } catch (CountElementsOfArrayException e) {
            logger.log(Level.DEBUG, this.getClass().getName() + " : incorrect initial data. array size is 0. return 0");
        }
        return 0.0;
    }
}
