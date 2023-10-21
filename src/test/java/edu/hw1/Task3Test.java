package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    void isNestableSuccess1() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {0, 6};

        boolean expected = true;
        boolean result = Task3.isNestable(a1, a2);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void isNestableSuccess2() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {2, 3};

        boolean expected = false;
        boolean result = Task3.isNestable(a1, a2);

        Assertions.assertEquals(expected, result);
    }
}
