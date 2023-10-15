package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {
    @Test
    void testCountDigitsWithZero() {
        assertThat(Task2.countDigits(0)).isEqualTo(1);
    }

    @Test
    void testCountDigitsWithNegative() {
        assertThat(Task2.countDigits(-100)).isEqualTo(3);
    }

    void testCountDigitsPositive() {
        assertThat(Task2.countDigits(544)).isEqualTo(3);
        assertThat(Task2.countDigits(4666)).isEqualTo(4);
    }
}
