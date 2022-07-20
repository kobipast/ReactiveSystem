package test.java.com;
import main.java.com.Util;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void testValidOperator() {
        String expression = "1+10/9";
        boolean result = Util.isArithmetic(expression);
        assertEquals(true, result);
    }

    @Test
    public void testInvalidOperator() {
        String expression = "1+10b9";
        boolean result = Util.isArithmetic(expression);
        assertEquals(false, result);
    }

}
