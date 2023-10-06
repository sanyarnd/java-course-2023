package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @DisplayName("Проверка длины чисел")
    @Test
    void standart() {
        assertEquals(3, Task2.countDigits(123));
    }

    void zero() {
        assertEquals(0, Task2.countDigits(0));
        assertEquals(0, Task2.countDigits(-0));
    }

    void minus() {
        assertEquals(2, Task2.countDigits(-24));
    }
}
