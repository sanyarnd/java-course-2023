package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    void standart() {
        assertEquals(true, Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        assertEquals(true, Task3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
        assertEquals(false, Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        assertEquals(false, Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }

    @Test
    void same_mas() {
        assertEquals(false, Task3.isNestable(new int[] {3, 1}, new int[] {1, 3}));
        assertEquals(false, Task3.isNestable(new int[] {1, 3}, new int[] {3, 1}));
    }
}
