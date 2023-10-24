package edu.hw2.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {
    @Test
    @DisplayName("тестим Constant")
    public void constant(){
        assertEquals(new Constant(6).evaluate(), 6);
        assertEquals(new Constant(-10).evaluate(), -10);
        assertEquals(new Constant(0).evaluate(), 0);
        assertEquals(new Constant(10000000).evaluate(), 10000000);
    }
    @Test
    @DisplayName("тестим Negate")
    public void negate(){
        assertEquals(new Negate(new Constant(6)).evaluate(), -6);
        assertEquals(new Negate(new Constant(-100)).evaluate(), 100);
        assertEquals(new Negate(new Constant(0)).evaluate(), 0);
    }
    @Test
    @DisplayName("тестим Addition")
    public void addition(){
        assertEquals(new Addition(new Constant(6), new Constant(5)).evaluate(), 11);
        assertEquals(new Addition(new Constant(-20), new Constant(5)).evaluate(), -15);
        assertEquals(new Addition(new Constant(-10), new Constant(10)).evaluate(), 0);
    }
    @Test
    @DisplayName("тестим Multiplication")
    public void multiplication(){
        assertEquals(new Multiplication(new Constant(6), new Constant(5)).evaluate(), 30);
        assertEquals(new Multiplication(new Constant(-20), new Constant(5)).evaluate(), -100);
        assertEquals(new Multiplication(new Constant(-10), new Constant(0)).evaluate(), 0);
        assertEquals(new Multiplication(new Constant(-10), new Constant(-3)).evaluate(), 30);
    }
    @Test
    @DisplayName("тестим Exponent")
    public void exponent(){
        assertEquals(new Exponent(new Constant(6), 1).evaluate(), 6);
        assertEquals(new Exponent(new Constant(-6), 2).evaluate(), 36);
        assertEquals(new Exponent(new Constant(-6), 3).evaluate(), -216);
        assertEquals(new Exponent(new Constant(4), 4).evaluate(), 256);
    }
}
