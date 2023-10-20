package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Число 4666 -> 4 цифры")
    void test1() {
        // given
        int digit = 4666;

        // when
        int result = Task2.countDigits(digit);

        // then
        assertEquals(result, 4);
    }

    @Test
    @DisplayName("Число 544 -> 3 цифры")
    void test2() {
        // given
        int digit = 544;

        // when
        int result = Task2.countDigits(digit);

        // then
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("Число 0 -> 1 цифра")
    void test3() {
        // given
        int digit = 0;

        // when
        int result = Task2.countDigits(digit);

        // then
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("Число -345 -> 3 цифры")
    void test4() {
        // given
        int digit = -345;

        // when
        int result = Task2.countDigits(digit);

        // then
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("Число -1234 -> 5 цифр")
    void test5() {
        // given
        int digit = -12345;

        // when
        int result = Task2.countDigits(digit);

        // then
        assertEquals(result, 5);
    }
}
