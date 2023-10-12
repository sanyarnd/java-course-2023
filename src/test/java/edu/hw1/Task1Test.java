package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @ParameterizedTest
    @CsvSource({"01:00, 60", "13:56, 836", "999:59, 59999"})
    public void testValidInput(String input, int expected) {
        assertEquals(expected, Task1.minutesToSeconds(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10:60", "20:70"})
    public void testInvalidSeconds(String input) {
        assertEquals(-1, Task1.minutesToSeconds(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12:34:56", "12:", ":34", "12:34:"})
    public void testInvalidFormat(String input) {
        assertEquals(-1, Task1.minutesToSeconds(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12:34a", "12:3b"})
    public void testInvalidCharacters(String input) {
        assertEquals(-1, Task1.minutesToSeconds(input));
    }
}
