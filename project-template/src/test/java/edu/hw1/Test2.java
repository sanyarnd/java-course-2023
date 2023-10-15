package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test2 {
    @Test
    public void testCountDigitsPositive() {
        assertEquals(4, Task2.countDigits(8800));
        assertEquals(3, Task2.countDigits(555));
        assertEquals(1, Task2.countDigits(0));
        assertEquals(1, Task2.countDigits(7));
        assertEquals(2, Task2.countDigits(35));
    }

    @Test
    public void testCountDigitsNegative() {
        assertEquals(4, Task2.countDigits(-1358));
        assertEquals(3, Task2.countDigits(-322));
        assertEquals(1, Task2.countDigits(-7));
        assertEquals(2, Task2.countDigits(-35));
    }
}
