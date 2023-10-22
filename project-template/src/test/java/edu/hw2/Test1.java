package edu.hw2;
import edu.hw2.Task2_1.Addition;
import edu.hw2.Task2_1.Constant;
import edu.hw2.Task2_1.Exponent;
import edu.hw2.Task2_1.Expression;
import edu.hw2.Task2_1.Multiplication;
import edu.hw2.Task2_1.Negate;
import org.junit.jupiter.api.Test;
import static org.apache.logging.log4j.core.appender.rewrite.MapRewritePolicy.Mode.Add;
import static org.junit.jupiter.api.Assertions.*;

public class Test1 {

    @Test
    public void testConstant() {
        Expression constant = new Constant(5.0);
        assertEquals(5.0, constant.evaluate());
    }

    @Test
    public void testAdd() {
        Expression add = new Addition(new Constant(2.0), new Constant(3.0));
        assertEquals(5.0, add.evaluate());
    }

    @Test
    public void testMultiply() {
        Expression multiply = new Multiplication(new Constant(2.0), new Constant(3.0));
        assertEquals(6.0, multiply.evaluate());
    }

    @Test
    public void testNegate() {
        Expression negate = new Negate(new Constant(5.0));
        assertEquals(-5.0, negate.evaluate());
    }

    @Test
    public void testExponentiation() {
        Expression exponentiation = new Exponent(new Constant(2.0), new Constant(3.0));
        assertEquals(8.0, exponentiation.evaluate());
    }
}
