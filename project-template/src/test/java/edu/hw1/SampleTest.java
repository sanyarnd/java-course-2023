package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    void getVideoLength() {
        Assertions.assertEquals(-1, Main.videoLength("mm:ss"));
        Assertions.assertEquals(-1, Main.videoLength("-100:-100"));
        Assertions.assertEquals(-1, Main.videoLength("-100:00"));
        Assertions.assertEquals(-1, Main.videoLength(":-10"));
        Assertions.assertEquals(-1, Main.videoLength("12:-10"));
        Assertions.assertEquals(-1, Main.videoLength("10:60"));
        Assertions.assertEquals(5999940, Main.videoLength("99999:00"));
        Assertions.assertEquals(600, Main.videoLength("10:00"));
    }

    @Test
    void getDigitCount() {
        Assertions.assertEquals(2, Main.digitCount(-10));
        Assertions.assertEquals(2, Main.digitCount(10));
        Assertions.assertEquals(1, Main.digitCount(0));
    }

    @Test
    void getIsNested(){
        Assertions.assertTrue(Main.isNestable(new Integer[]{1, 2, 3, 4}, new Integer[]{0, 5}));
        Assertions.assertFalse(Main.isNestable(new Integer[]{1, 2, 3, 4}, new Integer[]{0, 4}));
        Assertions.assertFalse(Main.isNestable(new Integer[]{1, 2, 3, 4}, new Integer[]{1, 5}));
        Assertions.assertFalse(Main.isNestable(new Integer[]{1, 2, 3, 4}, new Integer[]{1, 4}));
        Assertions.assertTrue(Main.isNestable(new Integer[]{3, 1}, new Integer[]{4, 0}));//Надо затестить нормальным образом
        Assertions.assertFalse(Main.isNestable(new Integer[]{3, 1}, new Integer[]{3, 1}));//Надо затестить нормальным образом
    }

    @Test
    void getFixedString(){
        Assertions.assertEquals("", Main.stringFix(""));
        Assertions.assertEquals("1", Main.stringFix("1"));
        Assertions.assertEquals("This is a mixed up string.", Main.stringFix("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    void getIsPalindrome(){
        Assertions.assertTrue(Main.isPalindrome(11211230));
        Assertions.assertTrue(Main.isPalindrome(11));
        Assertions.assertTrue(Main.isPalindrome(1));
        Assertions.assertTrue(Main.isPalindrome(101));
        Assertions.assertFalse(Main.isPalindrome(112));
        Assertions.assertTrue(Main.isPalindrome(-11));
    }

    @Test
    void getKaprekar(){
        Assertions.assertEquals(0, Main.kaprekar(1000));
        Assertions.assertEquals(0, Main.kaprekar(1111));
        Assertions.assertEquals(0, Main.kaprekar(10000));
        Assertions.assertEquals(0, Main.kaprekar(6174));
        Assertions.assertEquals(5, Main.kaprekar(6621));
    }

    @Test
    void getRotateRight(){
        Assertions.assertEquals(1, Main.rotateRight(1, 1));
        Assertions.assertEquals(4, Main.rotateRight(8, 1));
    }

    @Test
    void getRotateLeft(){
        Assertions.assertEquals(1, Main.rotateLeft(16, 1));
        Assertions.assertEquals(6, Main.rotateLeft(17, 2));
    }

    @Test
    void getKnights(){
        Assertions.assertTrue(Main.isKnightTakes(new int[][]{
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}}));
        Assertions.assertFalse(Main.isKnightTakes(new int[][]{
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}}));
    }
}
