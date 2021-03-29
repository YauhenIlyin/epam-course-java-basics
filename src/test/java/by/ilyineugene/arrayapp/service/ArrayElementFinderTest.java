package by.ilyineugene.arrayapp.service;

import by.ilyineugene.arrayapp.entity.EntityArray;
import by.ilyineugene.arrayapp.exception.OperationArrayException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayElementFinderTest {
    ArrayElementFinder arrayElementFinder = new ArrayElementFinder();
    EntityArray entityArray;

    @BeforeClass
    public void setUP() {
        arrayElementFinder = new ArrayElementFinder();
    }

    @AfterClass
    public void tearDown() {
        arrayElementFinder = null;
        entityArray = null;
    }

    @DataProvider(name = "Double data, min, positive result")
    public Object[][] createDoubleData() {
        return new Object[][]{
                {new Double[]{3.5, 4.5, 4.}, 3.5},
                {new Double[]{1., 2., 6.}, 1.},
                {new Double[]{0., 0., 0.}, 0.},
                {new Double[]{-1.3, -0.7, -1.}, -1.3}
                //можно ли отходить от норм "правописания", чтобы в таких местах делать код читабельнее? или это неправильно?
        };
    }

    @Test(dataProvider = "Double data, min, positive result", enabled = true)
    public void findMinValue(Double[] array, Double expected) throws OperationArrayException {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        Double actual = arrayElementFinder.findMinValue(entityArray.getArray());
        assertEquals(actual.doubleValue(), expected.doubleValue(), 0.001, "minValue of array test failure...");
    }

    @DataProvider(name = "Double data, max, positive result")
    public Object[][] createDoubleDataPositiveMin() {
        return new Object[][]{
                {new Double[]{1.5, 9.3, 4.}, 9.3},
                {new Double[]{1.5}, 1.5},
                {new Double[]{1., 2., 6.}, 6.},
                {new Double[]{10., 2., 6.}, 10.},
                {new Double[]{0., 0., 0.}, 0.},
                {new Double[]{-1.3, -0.7, -1.}, -0.7}
                //можно ли отходить от норм "правописания", чтобы в таких местах делать код читабельнее? или это неправильно?
        };
    }

    @Test(dataProvider = "Double data, max, positive result", enabled = true)
    public void findMaxValue(Double[] array, Double expected) throws OperationArrayException {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        Double actual = arrayElementFinder.findMaxValue(entityArray.getArray());
        assertEquals(actual.doubleValue(), expected.doubleValue(), 0.001, "maxValue of array test failure...");
    }
}
