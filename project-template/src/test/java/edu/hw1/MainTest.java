package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void minutesToSeconds() {
        assertEquals(90, Main.minutesToSeconds("1:30"));
        assertEquals(0, Main.minutesToSeconds("0:00"));
        assertEquals(3599, Main.minutesToSeconds("59:59"));
    }
    @Test
    void testInvalidInput() {
        assertEquals(3600, Main.minutesToSeconds("60:00"));
        assertEquals(-1, Main.minutesToSeconds("1:60"));
        assertEquals(-1, Main.minutesToSeconds("61:60"));
        assertEquals(-1, Main.minutesToSeconds("1:61"));
    }

    @Test
    void countDigits() {
        assertEquals(1, Main.countDigits(0));
        assertEquals(1, Main.countDigits(5));
        assertEquals(2, Main.countDigits(42));
        assertEquals(3, Main.countDigits(123));
        assertEquals(4, Main.countDigits(1000));
        assertEquals(10, Main.countDigits(9876543210L));
    }

    @Test
    void isNestable() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {0, 1, 2, 3, 4};
        assertTrue(Main.isNestable(a1, a2));
    }
    @Test
    public void testIsNestable2() {
        int[] a1 = {0, 1, 2, 3, 4};
        int[] a2 = {1, 2, 3};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable3() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable4() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable5() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3, 4};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable6() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3, 4, 5};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable7() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {3, 4, 5};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable8() {
        int[] a1 = {};
        int[] a2 = {1, 2, 3};
        assertFalse(Main.isNestable(a1, a2));
    }

    @Test
    public void testIsNestable9() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {};
        assertFalse(Main.isNestable(a1, a2));
    }
    @Test
    void fixString() {
        assertNull(Main.fixString(null));
    }
    @Test
    public void testFixString2() {
        assertEquals("", Main.fixString(""));
    }

    @Test
    public void testFixString3() {
        assertEquals("a", Main.fixString("a"));
    }

    @Test
    public void testFixString4() {
        assertEquals("bA", Main.fixString("Ab"));
        assertEquals("bAdC", Main.fixString("AbCd"));
        assertEquals("badcfehg", Main.fixString("abcdefgh"));
    }

    @Test
    void GetNextDescendantTest() {
        assertEquals("37", Main.getNextDescendant("1234"));
        assertEquals("816", Main.getNextDescendant("3579"));
    }

    @Test
    void isPalindrome() {
        assertFalse(Main.isPalindrome("78999387"));
        assertTrue(Main.isPalindrome("5665"));
        assertFalse(Main.isPalindrome("13001120"));
        assertTrue(Main.isPalindrome("77"));
        assertFalse(Main.isPalindrome("9869"));
    }

    @Test
    void testIsPalindromeDescendant() {
        assertTrue(Main.isPalindromeDescendant(11211230));
        assertTrue(Main.isPalindromeDescendant(23336014));
        assertFalse(Main.isPalindromeDescendant(12345));
    }

    @Test
    void countK() {
        assertEquals(0, Main.countK(6174));
        assertEquals(3, Main.countK(1234));
        assertEquals(3, Main.countK(4321));
        assertEquals(3, Main.countK(9876));
    }

    @Test
    void rotateLeft() {
        assertEquals(15, Main.rotateLeft(15, 3));
        assertEquals(33, Main.rotateLeft(48, 1));
        assertEquals(1, Main.rotateLeft(16, 1));
        assertEquals(1, Main.rotateLeft(8, 1));
    }

    @Test
    void rotateRight() {
        assertEquals(4, Main.rotateRight(8, 1));
        assertEquals(8, Main.rotateRight(16, 1));
        assertEquals(14, Main.rotateRight(14, 4));
        assertEquals(3, Main.rotateRight(3, 1));
    }

    @Test
    void knightBoardCapture() {
        int[][] board1 = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertTrue(Main.knightBoardCapture(board1));

        int[][] board2 = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0}
        };
        assertFalse(Main.knightBoardCapture(board2));

        int[][] board3 = {
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        assertFalse(Main.knightBoardCapture(board3));

        int[][] board4 = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertTrue(Main.knightBoardCapture(board4));

        int[][] board5 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        assertFalse(Main.knightBoardCapture(board5));
    }
}
