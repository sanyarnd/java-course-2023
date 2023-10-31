package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    @DisplayName("8, 1 -> 4 // rotateRight 1000 -> 0100")
    void test1() {
        // given
        int n = 8;
        int shift = 1;

        // when
        int result = Task7.rotateRight(n, shift);

        // then
        assertEquals(result, 4);
    }

    @Test
    @DisplayName("16, 1 -> 1 // rotateLeft 10000 -> 00001")
    void test2() {
        // given
        int n = 16;
        int shift = 1;

        // when
        int result = Task7.rotateLeft(n, shift);

        // then
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("17, 2 -> 6 // rotateLeft 10001 -> 00110 ")
    void test3() {
        // given
        int n = 17;
        int shift = 2;

        // when
        int result = Task7.rotateLeft(n, shift);

        // then
        assertEquals(result, 6);
    }
}
