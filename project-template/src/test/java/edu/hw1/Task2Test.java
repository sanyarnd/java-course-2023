package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {
    @Test void testCountDigitsWithZero() {
        assertEquals(Task2.countDigits(0), 1);
    }

    @Test void testCountDigitsWithNegative() {
        assertEquals(Task2.countDigits(-100), 3);
    }

    @Test void testCountDigitsPositive() {
        assertEquals(Task2.countDigits(544), 3);
        assertEquals(Task2.countDigits(4666), 4);
    }

    @Test void testCountDigitsIntMinValue() {
        assertEquals(Task2.countDigits(Integer.MIN_VALUE), 10);
        assertEquals(Task2.countDigits(-Integer.MIN_VALUE), 10);
    }

    @Test void testCountDigitsIntMaxValue() {
        assertEquals(Task2.countDigits(Integer.MAX_VALUE), 10);
        assertEquals(Task2.countDigits(-Integer.MAX_VALUE), 10);
    }
}
