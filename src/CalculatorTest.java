import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void addTest() {
        calculator = new Calculator();
        Assert.assertEquals(0, calculator.add(""));
        Assert.assertEquals(1, calculator.add("1"));
    }
}
