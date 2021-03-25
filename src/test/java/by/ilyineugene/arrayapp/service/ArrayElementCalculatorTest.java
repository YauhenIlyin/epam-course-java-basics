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
        ArrayElementCalculator arrayElementCalculator = new ArrayElementCalculator();
        //EntityArray entityArray = new EntityArray<>();
    }
    @AfterClass
    public void tearDown(){
        arrayElementCalculator = null;
        entityArray = null;
    }
    @DataProvider(name = "Double date")
    public Object[][] createData() {
        return new Object[][]{{new Object[]{3.5, 4.5, 4.0},4.0},{new Object[]{1.0, 2.0, 6.0},3.0}};
    }
    @Test(dataProvider = "Double date")
    public void calculateAverageValue(Double [] array, Double expected) {
        EntityArray<Double> entityArray = new EntityArray<>(array);
        double actual = arrayElementCalculator.calculateAverageValue(entityArray.getArray());
        assertEquals(actual, expected.doubleValue(), 0.001, "AverageValue of array test failure...");
    }
}
