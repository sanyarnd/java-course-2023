package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {
    @Test
    @DisplayName("Проверка CountDigits")
    void checkCountDigits() {
        assertEquals(countDigits(424), 3);
        assertEquals(countDigits(23413), 5);
        assertEquals(countDigits(93781293), 8);
        assertEquals(countDigits(0), 1);
        assertEquals(countDigits(14), 2);
        assertEquals(countDigits(Integer.MAX_VALUE), 10);
        assertEquals(countDigits(Integer.MIN_VALUE), 10);
    }
}
