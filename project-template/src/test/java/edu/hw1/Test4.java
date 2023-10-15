package edu.hw1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4 {
    @Test
    public void testStringEven() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", Task4.fixString("badce"));
    }

    @Test
    public void testStringOdd() {
        assertEquals("21435", Task4.fixString("12345"));
        assertEquals("This is a mixed up strin.", Task4.fixString("hTsii  s aimex dpus rtni."));
        assertEquals("abcde", Task4.fixString("badce"));
    }

    @Test
    public void testFixStringEmpty() {
        assertEquals("", Task4.fixString(""));
    }
}
