package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {
    @Test
    public void testMinutesToSeconds() {
        String[] testCases = new String[] {"01:00", "13:56", "10:60", "10:-1"};
        int[] expectedResults = new int[] {60, 836, -1, -1};

        for (int i = 0; i < testCases.length; i++) {
            assertEquals(Main.minutesToSeconds(testCases[i]), expectedResults[i]);
        }
    }

    @Test
    public void testCountDigits() {
        int[] testCases = new int[] {4666, 566, 0, -100, -1};
        int[] expectedResults = new int[] {4, 3, 1, 3, 1};

        for (int i = 0; i < testCases.length; i++) {
            assertEquals(Main.countDigits(testCases[i]), expectedResults[i]);
        }
    }

    @Test
    public void testIsNestable() {
        assertTrue(Main.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
        assertTrue(Main.isNestable(new int[] {3, 1}, new int[]{4, 0}));
        assertFalse(Main.isNestable(new int[] {9, 9, 8}, new int[]{8, 9}));
        assertFalse(Main.isNestable(new int[] {1, 2, 3, 4}, new int[]{2, 3}));
    }

    @Test
    public void testFixString() {
        String[] testCases = new String[]{"123456", "hTsii  s aimex dpus rtni.g", "badce"};
        String[] expectedResults = new String[]{"214365", "This is a mixed up string.", "abcde"};

        for(int i = 0; i < testCases.length; i++){
            assertEquals(Main.fixString(testCases[i]), expectedResults[i]);
        }
    }

    @Test
    public void testIsPalindromeDescendant() {
        int[] testCases = new int[] {11211230, 13001120, 23336014, 11, 112, 222, 42, 224, 16, 166, 167, 761, 0};
        boolean[] expectedResults =
            new boolean[] {true, true, true, true, true, true, false, true, false, false, true, true, false};

        for(int i = 0; i < testCases.length; i++){
            assertEquals(Main.isPalindromeDescendant(testCases[i]), expectedResults[i]);
        }
    }

    @Test
    public void testCountK() {
        int[] testCases = new int[] {3524, 6621, 6554, 1234};
        int[] expectedResults = new int[] {3, 5, 4, 3};

        for(int i = 0; i < testCases.length; i++){
            assertEquals(Main.countK(testCases[i]), expectedResults[i]);
        }
    }

    @Test
    public void testRotate() {
        assertEquals(Main.rotateRight(8, 1), 4);
        assertEquals(Main.rotateLeft(16, 1), 1);
        assertEquals(Main.rotateLeft(17, 2), 6);
    }

    @Test
    public void testKnightBoardCapture() {
        int[][] board1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        assertTrue(Main.knightBoardCapture(board1));

        int[][] board2 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        assertFalse(Main.knightBoardCapture(board2));

        int[][] board3 = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        assertFalse(Main.knightBoardCapture(board3));
    }
}
