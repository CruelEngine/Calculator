import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    // Taken staright from the documentation
    @Before
    public void initializeCalculator() {
        calculator= new Calculator();
    }

    @Test
    public void addTest() {
        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1"));
        assertEquals(3, calculator.add("1,2"));
        assertEquals(15, calculator.add("8,7"));
        assertEquals(40, calculator.add("5,6,7,9,13"));
        assertEquals(6,calculator.add("1\n2,3"));
        assertEquals(3, calculator.add("//;\n1;2"));

        try {
            calculator.add("-1,2");
            fail("Exception not thrown");
        }catch(IllegalArgumentException exception) {
            assertEquals("negatives not allowed", exception.getMessage());
        }

        assertEquals(2, calculator.add("1001,2"));
        assertEquals(10, calculator.add("//[***]\n2***3***5"));
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
        assertEquals(6, calculator.add("//[*][%]\n1**2%%3"));
        assertEquals(6, calculator.add("//[*][%]\n1*%2%*3"));
    }
}
