package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task7Test {
    @Test
    void testRotateRight() {
        assertEquals(Task7.rotateRight(8, 1), 4);
        assertEquals(Task7.rotateRight(16, 3), 2);
        assertEquals(Task7.rotateRight(25, 20), 25);
    }

    @Test
    void testRotateLeft() {
        assertEquals(Task7.rotateLeft(8, 0), 8);
        assertEquals(Task7.rotateLeft(16, 1), 1);
        assertEquals(Task7.rotateLeft(17, 2), 6);
    }

    @Test
    void testRotateRightWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Task7.rotateRight(-8, 1);
        });
        assertEquals(exception.getMessage(), Task7.NEG_NUM_EXCEPT_MSG);
    }

    @Test
    void testRotateLeftWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Task7.rotateLeft(-8, 1);
        });
        assertEquals(exception.getMessage(), Task7.NEG_NUM_EXCEPT_MSG);
    }
}
