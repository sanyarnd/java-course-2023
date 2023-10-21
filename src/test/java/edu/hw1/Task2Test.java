package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    void countDigitsSuccess() {
        int number = 4666;

        int expected = 4;
        int result = Task2.countDigits(number);

        Assertions.assertEquals(expected, result);
    }
}
