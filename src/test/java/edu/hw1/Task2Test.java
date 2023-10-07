package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testValidInput() {
        assertEquals(60, Task2.minutesToSeconds("01:00"));
        assertEquals(836, Task2.minutesToSeconds("13:56"));
        assertEquals(59999, Task2.minutesToSeconds("999:59"));
    }

    @Test
    public void testInvalidSeconds() {
        assertEquals(-1, Task2.minutesToSeconds("10:60"));
        assertEquals(-1, Task2.minutesToSeconds("20:70"));
    }

    @Test
    public void testInvalidFormat() {
        assertEquals(-1, Task2.minutesToSeconds("123"));
        assertEquals(-1, Task2.minutesToSeconds("12:34:56"));
        assertEquals(-1, Task2.minutesToSeconds("12:"));
        assertEquals(-1, Task2.minutesToSeconds(":34"));
        assertEquals(-1, Task2.minutesToSeconds("12:34:"));
    }

    @Test
    public void testInvalidCharacters() {
        assertEquals(-1, Task2.minutesToSeconds("12:34a"));
        assertEquals(-1, Task2.minutesToSeconds("12:3b"));
    }
}
