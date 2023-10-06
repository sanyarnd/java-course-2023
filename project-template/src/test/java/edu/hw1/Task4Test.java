package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void standart() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", Task4.fixString("badce"));
    }

    @Test
    void solo() {
        assertEquals("1", Task4.fixString("1"));

    }

    @Test
    void odd_len() {
        assertEquals("1234567", Task4.fixString("2143657"));
    }

    @Test
    void even_len() {
        assertEquals("1234", Task4.fixString("2143"));
    }
}
