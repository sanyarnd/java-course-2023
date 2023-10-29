package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    void rotateLeftSuccess() {
        int result = Task7.rotateLeft(16, 1);
        int expected = 1;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void rotateRightSuccess() {
        int result = Task7.rotateRight(8, 1);
        int expected = 4;

        Assertions.assertEquals(expected, result);
    }
}
