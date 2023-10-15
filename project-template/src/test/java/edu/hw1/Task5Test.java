package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task5Test {
    @Test
    public void testIsPalindromeDescendantWithPalindromeNumber() {
        assertTrue(Task5.isPalindromeDescendant(11));
    }

    @Test
    public void testIsPalindromeDescendantWithInvalidNumber() {
        assertFalse(Task5.isPalindromeDescendant(7244));
        assertFalse(Task5.isPalindromeDescendant(255531));
    }

    @Test
    public void testIsPalindromeDescendantWithValidDescendant() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(23336014));
        assertTrue(Task5.isPalindromeDescendant(13001120));
    }
}
