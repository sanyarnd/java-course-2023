package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {
    @Test
    void isNestableTrue() {
        assertTrue(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        assertTrue(Task3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
    }

    @Test
    void isNestableFalse() {
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 6}, new int[] {1, 2, 3, 6}));
        assertFalse(Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
        assertFalse(Task3.isNestable(new int[] {}, new int[] {}));
        assertFalse(Task3.isNestable(new int[] {}, new int[] {1}));
    }
}
