package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {
    @Test
    public void testFixStringWithEvenLength() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    public void testFixStringWithOddLength() {
        assertEquals("21435", Task4.fixString("12345"));
        assertEquals("abcde", Task4.fixString("badce"));
    }
}
