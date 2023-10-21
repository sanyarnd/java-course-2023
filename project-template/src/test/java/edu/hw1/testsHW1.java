package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testsHW1 {
    @Test
    public void videoLength() {
        int a1 = Video.lengthVideo("12:14");
        int a2 = Video.lengthVideo("01:10");
        int a3 = Video.lengthVideo("01:70");
        int a4 = Video.lengthVideo("");
        int a5 = Video.lengthVideo("235sgdd:eg");
        int a6 = Video.lengthVideo("111:40");
        Assertions.assertEquals(6700, a6);
        Assertions.assertEquals(-1, a5);
        Assertions.assertEquals( -1, a4);
        Assertions.assertEquals(734, a1);
        Assertions.assertEquals(70, a2);
        Assertions.assertEquals(-1, a3);
    }
    @Test
    public void countDigit() {
        int d1 = Digits.countDigit(125);
        int d4 = Digits.countDigit(-125);
        int d3 = Digits.countDigit(1);
        int d2 = Digits.countDigit(0);

        Assertions.assertEquals(3, d1);
        Assertions.assertEquals(1, d2);
        Assertions.assertEquals(1, d3);
        Assertions.assertEquals(3, d4);
    }
    @Test
    public void attachedArray(){
        Assertions.assertTrue(Arrays.attachedArray(new int[] {1, 2, 3, 4}, 3, new int[] {0, 6}, 2));
        Assertions.assertTrue(Arrays.attachedArray(new int[] {3, 1}, 2, new int[] {4, 0}, 2));
        Assertions.assertFalse(Arrays.attachedArray(new int[] {9,9,8}, 3 , new int[] {8, 9}, 2));
        Assertions.assertFalse(Arrays.attachedArray(new int[] {1, 2, 3, 4}, 3, new int[] {2,3}, 2));
    }
    @Test
    public void incorrectString(){
        Assertions.assertEquals("214365", FixString.incorrectString("123456"));
        Assertions.assertEquals("This is a mixed up string.", FixString.incorrectString("hTsii  s aimex dpus rtni.g"));
        Assertions.assertEquals("abcde", FixString.incorrectString("badce"));
    }
    @Test
    public void kaprekar(){
        Assertions.assertEquals(0, Kaprekar.countK(6174));
        Assertions.assertEquals(3, Kaprekar.countK(3524));
        Assertions.assertEquals(5, Kaprekar.countK(6621));
        Assertions.assertEquals(4, Kaprekar.countK(6554));
        Assertions.assertEquals(3, Kaprekar.countK(1234));
    }
    @Test
    public void specialPolindrom(){
        Assertions.assertTrue(Polindrom.isPolindromeDescendant(11211230));
        Assertions.assertTrue(Polindrom.isPolindromeDescendant(13001120));
        Assertions.assertTrue(Polindrom.isPolindromeDescendant(23336014));
        Assertions.assertFalse(Polindrom.isPolindromeDescendant(1234));

    }
    @Test
    public void rightRotate(){
        Assertions.assertEquals(4, Rotator.rotateRight(8, 5));
        Assertions.assertEquals(1, Rotator.rotateRight(1, 5));
        Assertions.assertEquals(4, Rotator.rotateRight(8, 1));
        Assertions.assertEquals(1, Rotator.rotateRight(1, 1));
        Assertions.assertEquals(8, Rotator.rotateRight(16, 1));
        Assertions.assertEquals(12, Rotator.rotateRight(17, 2));
    }
    @Test
    public void leftRotate(){
        Assertions.assertEquals(1, Rotator.rotateLeft(16, 1));
        Assertions.assertEquals(1, Rotator.rotateLeft(16, 6));
        Assertions.assertEquals(6, Rotator.rotateLeft(17, 2));
    }
    @Test
    public void chessKnight(){
        Assertions.assertTrue(new ChessHorse(new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        }).knightBoardCapture());

        Assertions.assertFalse(new ChessHorse(new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        }).knightBoardCapture());

        Assertions.assertFalse(new ChessHorse(new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        }).knightBoardCapture());
    }
}
