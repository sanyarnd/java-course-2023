package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task7Test {
    @Test
    void testRotateRight() {
        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7.rotateRight(16, 3)).isEqualTo(2);
        assertThat(Task7.rotateRight(25, 20)).isEqualTo(25);
    }

    @Test
    void testRotateLeft() {
        assertThat(Task7.rotateLeft(8, 0)).isEqualTo(8);
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);
    }

    @Test
    void testRotateRightWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Task7.rotateRight(-8, 1);
        });
        assertThat(exception.getMessage()).isEqualTo(Task7.negNumExceptMsg);
    }

    @Test
    void testRotateLeftWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Task7.rotateLeft(-8, 1);
        });
        assertThat(exception.getMessage()).isEqualTo(Task7.negNumExceptMsg);
    }
}
