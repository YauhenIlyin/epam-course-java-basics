package by.ilyineugene.arrayapp.service;

import by.ilyineugene.arrayapp.entity.EntityArray;
import by.ilyineugene.arrayapp.exception.OperationArrayException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayElementCalculatorTest {
    ArrayElementCalculator arrayElementCalculator;
    EntityArray entityArray;

    @BeforeClass
    public void setUP() {
        arrayElementCalculator = new ArrayElementCalculator();
    }

    @AfterClass
    public void tearDown() {
        arrayElementCalculator = null;
        entityArray = null;
    }

    @DataProvider(name = "Double data, positive result")
    public Object[][] createDoubleData() {
        return new Object[][]{
                {new Double[]{3.5, 4.5, 4.}, 4.},
                {new Double[]{1., 2., 6.}, 3.},
                {new Double[]{0., 0., 0.}, 0.},
                {new Double[]{-1.3, -0.7, -1.}, -1.}
                //можно ли отходить от норм "правописания", чтобы в таких местах делать код читабельнее? или это неправильно?
        };
    }

    @Test(dataProvider = "Double data, positive result", enabled = true)
    public void calculateAverageValue(Double[] array, Double expected) throws OperationArrayException {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        Double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertEquals(actual.doubleValue(), expected.doubleValue(), 0.001, "AverageValue of array test failure...");
    }

        @DataProvider(name = "Integer data, positive result")
        public Object[][] createIntegerData () {
        return new Object[][]{
                {new Integer[]{1, 2, 3}, 2},
                {new Integer[]{1, 2, 6}, 3},
                {new Integer[]{0, 0, 0}, 0},
                {new Integer[]{-1, -7, -1}, -3}
        };
        //можно ли отходить от норм "правописания", чтобы в таких местах делать код читабельнее? или это неправильно?
    }

        @Test(dataProvider = "Integer data, positive result", enabled = true)
        public void calculateAverageValue (Integer[]array, Integer expected) throws OperationArrayException {
        EntityArray<Integer> entityArray = new EntityArray<>(array);
        Double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertEquals(actual.intValue(), expected.intValue(), 0.001, "AverageValue of array test failure...");
    }

    @DataProvider(name = "Error data, exception result")
    public Object[][] createNullData() {
        return new Object[][]{
                {null, 2}, {new Integer[0], 0},
        };
    }

    @Test(dataProvider = "Error data, exception result", expectedExceptions = OperationArrayException.class, expectedExceptionsMessageRegExp = "count error. it is impossible to find the average of 0 elements or array is null", enabled = true)
    public void calculateAverageValueOfNull(Integer[] array, Integer expected) throws OperationArrayException {
        EntityArray<Integer> entityArray = new EntityArray<>(array);
        Double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertEquals(actual.intValue(), expected.intValue(), 0.001, "AverageValue of array test failure...");
    }

    @DataProvider(name = "Double data, negative result")
    public Object[][] createDoubleDataNegative() {
        return new Object[][]{
                {new Double[]{3.5, 4.5, 4.}, 22.},
                {new Double[]{1., 2., 6.}, -17.},
                {new Double[]{0., 0., 0.}, 5.},
                {new Double[]{-1.3, -0.7, -1.}, 100.}
                //можно ли отходить от норм "правописания", чтобы в таких местах делать код читабельнее? или это неправильно?
        };
    }

    @Test(dataProvider = "Double data, negative result", enabled = true)
    public void calculateAverageValueNegativeDouble(Double[] array, Double expected) throws OperationArrayException {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        Double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertNotEquals(actual.doubleValue(), expected.doubleValue(), 0.001, "AverageValue of array test failure...");
    }
}
