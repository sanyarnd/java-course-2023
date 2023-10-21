package edu.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.hw2.Expression.Expr.*;

public class ExprTest {
    @Test
    public void Constant(){
        Assertions.assertEquals(1, new Constant(1).evaluate());
        Assertions.assertEquals(1, new Constant(new Constant(1)).evaluate());
        Assertions.assertEquals(-1, new Constant(-1).evaluate());
        Assertions.assertEquals(0, new Constant(0).evaluate());
    }

    @Test
    public void Negate(){
        Assertions.assertEquals(-1, new Negate(1).evaluate());
        Assertions.assertEquals(1, new Negate(-1).evaluate());
        Assertions.assertEquals(-1, new Negate(new Constant(1)).evaluate());
        Assertions.assertEquals(1, new Negate(new Constant(-1)).evaluate());
        Assertions.assertTrue(0 == new Negate(0).evaluate());
    }

    @Test
    public void Exponent(){
        Assertions.assertEquals(1, new Exponent(1, 4).evaluate());
        Assertions.assertEquals(-1, new Exponent(-1, 3).evaluate());
        Assertions.assertEquals(16, new Exponent(new Constant(4), new Constant(2)).evaluate());
        Assertions.assertEquals(4, new Exponent(new Constant(4), 1).evaluate());
        Assertions.assertEquals(4, new Exponent(4, new Constant(1)).evaluate());
    }

    @Test
    public void Additional(){
        Assertions.assertEquals(5, new Addition(1, 4).evaluate());
        Assertions.assertEquals(2, new Addition(-1, 3).evaluate());
        Assertions.assertEquals(6, new Addition(new Constant(4), new Constant(2)).evaluate());
        Assertions.assertEquals(5, new Addition(new Constant(4), 1).evaluate());
        Assertions.assertEquals(5, new Addition(4, new Constant(1)).evaluate());
    }

    @Test
    public void Multiplication(){
        Assertions.assertEquals(4, new Multiplication(1, 4).evaluate());
        Assertions.assertEquals(-3, new Multiplication(-1, 3).evaluate());
        Assertions.assertEquals(8, new Multiplication(new Constant(4), new Constant(2)).evaluate());
        Assertions.assertEquals(4, new Multiplication(new Constant(4), 1).evaluate());
        Assertions.assertEquals(4, new Multiplication(4, new Constant(1)).evaluate());
    }
}
