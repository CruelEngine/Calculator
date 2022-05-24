import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void addTest() {
        calculator = new Calculator();
        Assert.assertEquals(0, calculator.add(""));
        Assert.assertEquals(1, calculator.add("1"));
        Assert.assertEquals(3, calculator.add("1,2"));
        Assert.assertEquals(15, calculator.add("8,7"));
        Assert.assertEquals(40, calculator.add("5,6,7,9,13"));
    }
}
