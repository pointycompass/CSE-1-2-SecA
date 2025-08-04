import org.junit.Assert;
import org.junit.Test;

class Calculator 
{
    int sum(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        return a/b;
    }
}

public class JUnitTest {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(1, 3), 4);
    }

    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sub(3, 1), 2);
    }

    @Test
    public void testMul() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.mul(2, 3), 6);
    }

    @Test
    public void testDiv() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.div(12, 3), 4);
    }
    
}