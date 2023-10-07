package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task8Test {

    @Test
    @DisplayName("Циклический сдвиг вправо")
    void testRotateRight() {
        assertThat(Task8.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task8.rotateRight(16, 1)).isEqualTo(8);
        assertThat(Task8.rotateRight(17, 2)).isEqualTo(12);
    }

    @Test
    @DisplayName("Циклический сдвиг влево")
    void testRotateLeft() {
        assertThat(Task8.rotateLeft(7, 1)).isEqualTo(7);
        assertThat(Task8.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task8.rotateLeft(17, 2)).isEqualTo(6);
    }

    @Test
    @DisplayName("Считает количество битов числа")
    void testNumberOfBits() {
        assertThat(Task8.numberOfBits(8)).isEqualTo(4);
        assertThat(Task8.numberOfBits(16)).isEqualTo(5);
        assertThat(Task8.numberOfBits(17)).isEqualTo(5);
    }
}
