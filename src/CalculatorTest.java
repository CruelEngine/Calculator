import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void addTest() {
        calculator = new Calculator();
        Assert.assertEquals("should return 0 for empty string", calculator.add(""));
    }
}
