package edu.hw1;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;


public class Test7 {

    @Test
    public void testRotateRight() {
        int n = 8;
        int k = 1;
        int expected = 4;

        int result = Task7.rotateRight(n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testRotateLeft() {
        int n = 16;
        int k = 1;
        int expected = 1;

        int result = Task7.rotateLeft(n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testRotateLeftWithMultipleBits() {
        int n = 17;
        int k = 2;
        int expected = 6;

        int result = Task7.rotateLeft(n, k);
        assertEquals(expected, result);
    }
}
