package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test1 {
    @Test
    public void testMinutesToSecondsValidInput() {
        assertEquals(60, Task1.minutesToSeconds("01:00"));
        assertEquals(836, Task1.minutesToSeconds("13:56"));
    }

    @Test
    public void testMinutesToSecondsInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("invalid"));
    }

    @Test
    public void testMinutesToSecondsNegativeMinutes() {
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("-10:30"));
    }

    @Test
    public void testMinutesToSecondsNegativeSeconds() {
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("10:-30"));
    }

    @Test
    public void testMinutesToSecondsInvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("abc:def"));
    }
}



