package by.training.khoroneko.util;

import by.training.khoroneko.exception.CalculateException;
import org.junit.Assert;
import org.junit.Test;

public class CalculateStringToIntTest {

    @Test(expected = CalculateException.class)
    public void calculateByPolishNotationTestNullExpectException() throws CalculateException{
        new CalculateStringToInt().calculateByPolishNotation(null);
    }

    @Test
    public void calculateByPolishNotationTestNormal() throws CalculateException{
        int actual = new CalculateStringToInt().calculateByPolishNotation("~6&9");
        int expected = ~6&9;
        Assert.assertEquals(expected, actual);
    }
}