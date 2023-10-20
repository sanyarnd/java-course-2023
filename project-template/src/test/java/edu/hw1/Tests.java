package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task1.minutesToSeconds;
import static edu.hw1.Task2.countDigits;
import static edu.hw1.Task3.isNestable;
import static edu.hw1.Task4.fixString;
import static edu.hw1.Task5.isPalindromeDescendant;
import static edu.hw1.Task6.countK;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task7.rotateRight;
import static edu.hw1.Task8.isKnightTakes;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    @DisplayName("Проверка времени")
    void checkTask1() {
        //assertThat(evenNumbers);
        assertEquals(minutesToSeconds("44:56"), 44 * 60 + 56);
        assertEquals(minutesToSeconds("444444:30"), 444444 * 60 + 30);
        assertEquals(minutesToSeconds("-2:00"), -1);
        assertEquals(minutesToSeconds("1:60"), -1);
        assertEquals(minutesToSeconds("one:zero"), -1);
        assertEquals(minutesToSeconds("0:98"), -1);
        assertEquals(minutesToSeconds("0:48"), 48);
        assertEquals(minutesToSeconds("0:48:00"), -1);
    }

    @Test
    @DisplayName("Проверка CountDigits")
    void checkTask2() {
        assertEquals(countDigits(424), 3);
        assertEquals(countDigits(23413), 5);
        assertEquals(countDigits(93781293), 8);
        assertEquals(countDigits(0), 1);
        assertEquals(countDigits(14), 2);
        assertEquals(countDigits(-875), -1);
    }

    @Test
    @DisplayName("Проверка isNestable")
    void checkTask3() {
        assertEquals(isNestable(new int[] {3, 1}, new int[] {4, 0}), true);
        assertEquals(isNestable(new int[] {1, 2, 3, 4}, new int[] {3, 2}), false);
        assertEquals(isNestable(new int[] {1, 2, 3, 4}, new int[] {6, 0}), true);
        assertEquals(isNestable(new int[] {9, 9, 8}, new int[] {8, 9}), false);
    }

    @Test
    @DisplayName("Проверка fixString")
    void checkTask4() {
        assertEquals(fixString("123456"), "214365");
        assertEquals(fixString("1454568"), "4145658");
        assertEquals(fixString("оПомигети псаривьтс ртко!и"), "Помогите исправить строки!");
        assertEquals(fixString("hTsii  s aimex dpus rtni.g"), "This is a mixed up string.");
        assertEquals(fixString("badce"), "abcde");
    }

    @Test
    @DisplayName("Проверка isPalindromeDescendant")
    void checkTask5() {
        assertEquals(isPalindromeDescendant(13001120), true);
        assertEquals(isPalindromeDescendant(11211230), true);
        assertEquals(isPalindromeDescendant(10211230), false);
        assertEquals(isPalindromeDescendant(0), false);
        assertEquals(isPalindromeDescendant(11), true);
        assertEquals(isPalindromeDescendant(7), false);
    }

    @Test
    @DisplayName("Проверка countK")
    void checkTask6() {
        assertEquals(countK(3524), 3);
        assertEquals(countK(6621), 5);
        assertEquals(countK(6174), 0);
        assertEquals(countK(324), -1);
        assertEquals(countK(10000), -1);
        assertEquals(countK(6554), 4);
        assertEquals(countK(1234), 3);
    }

    @Test
    @DisplayName("Проверка сдвигов")
    void checkTask7() {
        assertEquals(rotateRight(8, 1), 4);
        assertEquals(rotateLeft(16, 1), 32);
        assertEquals(rotateLeft(17, 2), 68);

    }

    @Test
    @DisplayName("Проверка хода конями")
    void checkTask8() {
        assertEquals(isKnightTakes(
            new int[][] {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}}), true);
        assertEquals(isKnightTakes(
            new int[][] {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}}), false);
            assertEquals(isKnightTakes(
            new int[][] {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}}), false);
    }
}
