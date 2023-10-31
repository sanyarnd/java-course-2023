package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("11211230 -> 2333 -> 56 -> 11 -> true")
    void test1() {
        // given
        int digit = 11211230;

        // when
        boolean result = Task5.isPalindromeDescendant(digit);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("13001120 -> 4022 ➞ 44 -> true")
    void test2() {
        // given
        int digit = 13001120;

        // when
        boolean result = Task5.isPalindromeDescendant(digit);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("23336014 -> 5665 -> true")
    void test3() {
        // given
        int digit = 23336014;

        // when
        boolean result = Task5.isPalindromeDescendant(digit);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("11 -> true")
    void test4() {
        // given
        int digit = 11;

        // when
        boolean result = Task5.isPalindromeDescendant(digit);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("1234 -> false")
    void test5() {
        // given
        int digit = 1234;

        // when
        boolean result = Task5.isPalindromeDescendant(digit);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("1 -> false")
    void test6() {
        // given
        int digit = 1;

        // when
        boolean result = Task5.isPalindromeDescendant(digit);

        // then
        assertFalse(result);
    }
}
