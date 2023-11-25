package edu.hw7;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {
    @Test
    void testCountFactorialWithSmallPositive() {
        int number = 5;
        BigInteger factorial = BigInteger.valueOf(120);
        assertEquals(factorial, Task2.countFactorial(number));
    }

    @Test
    void testCountFactorialWithLargePositive() {
        int number = 20;
        BigInteger factorial = new BigInteger("2432902008176640000");
        BigInteger result = Task2.countFactorial(number);
        assertEquals(factorial, result);
    }

    @Test
    void testCountFactorialWithNegative() {
        int negativeNumber = -1;
        assertThrows(IllegalArgumentException.class, () -> Task2.countFactorial(negativeNumber));
    }

    @Test
    void testCountFactorialWithZero() {
        int number = 0;
        assertEquals(BigInteger.ONE, Task2.countFactorial(number));
    }
}
