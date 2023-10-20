package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("6621 -> 5")
    void test1() {
        // given
        int digit = 6621;

        // when
        int result = Task6.countK(digit);

        // then
        assertEquals(result, 5);
    }

    @Test
    @DisplayName("6554 -> 4")
    void test2() {
        // given
        int digit = 6554;

        // when
        int result = Task6.countK(digit);

        // then
        assertEquals(result, 4);
    }

    @Test
    @DisplayName("1234 -> 3")
    void test3() {
        // given
        int digit = 1234;

        // when
        int result = Task6.countK(digit);

        // then
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("3333 -> -1")
    void test4() {
        // given
        int digit = 3333;

        // when
        int result = Task6.countK(digit);

        // then
        assertEquals(result, -1);
    }

    @Test
    @DisplayName("23 -> -1")
    void test5() {
        // given
        int digit = 23;

        // when
        int result = Task6.countK(digit);

        // then
        assertEquals(result, -1);
    }
}
