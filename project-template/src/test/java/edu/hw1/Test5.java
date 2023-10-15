package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test5 {

    @Test
    public void testIsPalindromeDescendant_Palindrome() {
        assertTrue(Task5.isPalindromeDescendant(121));
        assertTrue(Task5.isPalindromeDescendant(1331));
        assertTrue(Task5.isPalindromeDescendant(11));
        assertTrue(Task5.isPalindromeDescendant(0));
    }

    @Test
    public void testIsPalindromeDescendant_NonPalindrome() {
        assertFalse(Task5.isPalindromeDescendant(12345));
        assertFalse(Task5.isPalindromeDescendant(987654321));
    }

    @Test
    public void testIsPalindromeDescendant_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Task5.isPalindromeDescendant(-123));
    }



    @Test
    public void testReverseInt() {
        assertEquals(0, Task5.reverseInt(0));
        assertEquals(123, Task5.reverseInt(321));
        assertEquals(987654321, Task5.reverseInt(123456789));
    }
}
