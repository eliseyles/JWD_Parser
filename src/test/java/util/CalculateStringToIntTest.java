package util;

import exception.CalculateException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateStringToIntTest {

    @Test(expected = CalculateException.class)
    public void calculateByPolishNotationTestNullExpectException() throws CalculateException{
        new CalculateStringToInt().calculateByPolishNotation(null);
    }

    @Test(expected = CalculateException.class)
    public void calculateByPolishNotationTestNotMatchesExpectException() throws CalculateException{
        new CalculateStringToInt().calculateByPolishNotation("ab1");
    }

    @Test
    public void calculateByPolishNotationTestNormal() throws CalculateException{
        int actual = new CalculateStringToInt().calculateByPolishNotation("~6&9");
        int expected = ~6&9;
        Assert.assertEquals(expected, actual);
    }
}