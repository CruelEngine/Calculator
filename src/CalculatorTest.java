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
    public void shouldDoNothing() {

    }

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAdditionOfTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(15, calculator.add("8,7"));
    }

    @Test
    public void testAdditionOfUnlimitedNumbers() {
        assertEquals(40, calculator.add("5,6,7,9,13"));
    }

    @Test
    public void testAdditionUsingNewlineDelimiter() {
        assertEquals(6,calculator.add("1\n2,3"));
    }

    @Test
    public void testAdditionUsingCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbersNotAllowed() {
        try {
            calculator.add("-1,2");
            fail("Exception not thrown");
        }catch(IllegalArgumentException exception) {
            assertEquals("negatives not allowed", exception.getMessage());
        }
    }

    @Test
    public void testNumbersGreaterThan1000LimitNotEvaluated() {
        assertEquals(2, calculator.add("1001,2"));
        assertEquals(2, calculator.add("2001,2"));
    }

    @Test
    public void testMultipleCharactersOfSameDelimiter() {
        assertEquals(10, calculator.add("//[***]\n2***3***5"));
    }

    @Test
    public void testMultipleDelimiter() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleCharacterSequenceDelimiter() {
        assertEquals(6, calculator.add("//[*][%]\n1**2%%3"));
    }

    @Test
    public void testMultipleCombinationOfDelimiter() {
        assertEquals(6, calculator.add("//[*][%]\n1*%2%*3"));
    }

}
