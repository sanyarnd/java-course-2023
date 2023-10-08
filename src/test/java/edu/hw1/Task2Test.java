package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testValidInput() {
        assertEquals(60, Task2.minutesToSeconds("01:00"));
        assertEquals(836, Task2.minutesToSeconds("13:56"));
        assertEquals(59999, Task2.minutesToSeconds("999:59"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10:60", "20:70"})
    public void testInvalidSeconds(String input) {
        assertEquals(-1, Task2.minutesToSeconds(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12:34:56", "12:", ":34", "12:34:"})
    public void testInvalidFormat(String input) {
        assertEquals(-1, Task2.minutesToSeconds(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12:34a", "12:3b"})
    public void testInvalidCharacters(String input) {
        assertEquals(-1, Task2.minutesToSeconds(input));
    }
}
