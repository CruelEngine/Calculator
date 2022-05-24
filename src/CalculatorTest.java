import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    private void addTest() {
        Assert.assertEquals("should return 0 for empty string", calculator.add(""));
    }
}
