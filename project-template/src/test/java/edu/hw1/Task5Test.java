package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    void isPalindromeDescendantSuccess1() {
        int number = 11211230;

        boolean expected = true;
        boolean result = Task5.isPalindromeDescendant(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void isPalindromeDescendantSuccess2() {
        int number = 13001120;

        boolean expected = true;
        boolean result = Task5.isPalindromeDescendant(number);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void isPalindromeDescendantSuccess3() {
        int number = 23336014;

        boolean expected = true;
        boolean result = Task5.isPalindromeDescendant(number);

        Assertions.assertEquals(expected, result);
    }
}
