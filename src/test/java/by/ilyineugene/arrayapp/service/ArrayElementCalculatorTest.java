package by.ilyineugene.arrayapp.service;

import by.ilyineugene.arrayapp.entity.EntityArray;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
    @DataProvider(name = "Double data")
    public Object[][] createDoubleData() {
        return new Object[][]{
                { new Double[]{3.5, 4.5, 4.},4. },
                { new Double[]{1., 2., 6.},3. },
                { new Double[]{0., 0., 0.},0 },
                { new Double[]{-1.3, -0.7, -1.},-1. }
        };
    }
    @Test(dataProvider = "Double data")
    public void calculateAverageValue(Double [] array, Double expected) {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        Double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertEquals(actual.doubleValue(), expected.doubleValue(), 0.001, "AverageValue of array test failure...");
    }

    @DataProvider(name = "Integer data")
    public Object[][] createIntegerData() {
        return new Object[][]{
                { new Double[]{1, 2, 3},2 },
                { new Double[]{1., 2., 6.},3. },
                { new Double[]{0., 0., 0.},0 },
                { new Double[]{-1.3, -0.7, -1.},-1. }
        };
    }
    @Test(dataProvider = "Integer data")
    public void calculateAverageValue(Integer [] array, Integer expected) {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        Double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertEquals(actual.doubleValue(), expected.doubleValue(), 0.001, "AverageValue of array test failure...");
    }
}
