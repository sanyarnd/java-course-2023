package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("[1, 2, 3, 4], [0, 6] -> true")
    void test1() {
        // given
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{0, 6};

        // when
        boolean result = Task3.isNestable(a1, a2);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("[3, 1], [4, 0] -> true")
    void test2() {
        // given
        int[] a1 = new int[]{3, 1};
        int[] a2 = new int[]{4, 0};

        // when
        boolean result = Task3.isNestable(a1, a2);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("[9, 9, 8], [8, 9] -> false")
    void test3() {
        // given
        int[] a1 = new int[]{9, 9, 8};
        int[] a2 = new int[]{8, 9};

        // when
        boolean result = Task3.isNestable(a1, a2);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("[1, 2, 3, 4], [2, 3] -> false")
    void test4() {
        // given
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{2, 3};

        // when
        boolean result = Task3.isNestable(a1, a2);

        // then
        assertFalse(result);
    }
}
