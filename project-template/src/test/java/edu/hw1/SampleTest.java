package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Main.countDigits;
import static edu.hw1.Main.countK;
import static edu.hw1.Main.fixString;
import static edu.hw1.Main.isNestable;
import static edu.hw1.Main.isPalindromeDescendant;
import static edu.hw1.Main.knightBoardCapture;
import static edu.hw1.Main.minutesToSeconds;
import static edu.hw1.Main.rotateLeft;
import static edu.hw1.Main.rotateRight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
//    @Test
//    @DisplayName("Фильтрация четных чисел")
//    void filterEvenNumbers() {
//        // given
//        int[] numbers = new int[] {1, 2, 3, 4, 5};
//
//        // when
//        int[] evenNumbers = EvenArrayUtils.filter(numbers);
//
//        // then
//        assertThat(evenNumbers)
//            .containsExactly(2, 4)
//            .hasSize(2);
//    }

    @Test
    @DisplayName("Длина видео")
    void Task1() {
        String s1 = "01:60";
        int expRes1 = -1;
        String s2 = "01:59";
        int expRes2 = 119;

        int result1 = minutesToSeconds(s1);
        int result2 = minutesToSeconds(s2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }

    @Test
    @DisplayName("Количество цифр")
    void Task2() {
        int num1 = -1;
        int expRes1 = 1;
        int num2 = 999999999;
        int expRes2 = 9;

        int result1 = countDigits(num1);
        int result2 = countDigits(num2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }

    @Test
    @DisplayName("Вложенный массив")
    void Task3() {
        int[] array1_1 = {1, 1, 1, 1};
        int[] array2_1 = {1, 1};
        boolean expRes1 = false;
        int[] array1_2 = {8, 8, 8, 8};
        int[] array2_2 = {8, 8, 9, 9, 7};
        boolean expRes2 = true;

        boolean result1 = isNestable(array1_1, array2_1);
        boolean result2 = isNestable(array1_2, array2_2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }
    @Test
    @DisplayName("Сломанная строка")
    void Task4() {
        String str1 = "1111";
        char[] arr1 = str1.toCharArray();
        String strEes1 = "1111";
        char[] expRes1 = strEes1.toCharArray();

        String str2 = "ebn ci e";
        char[] arr2 = str2.toCharArray();
        String strEes2 = "be nice ";
        char[] expRes2 = strEes2.toCharArray();

        char[] result1 = fixString(arr1);
        char[] result2 = fixString(arr2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }

    @Test
    @DisplayName("Особый палиндром")
    void Task5() {
        int num1 = 112232211;
        boolean expRes1 = true;

        int num2 = 696969;
        boolean expRes2 = true;

        boolean result1 = isPalindromeDescendant(num1);
        boolean result2 = isPalindromeDescendant(num2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }

    @Test
    @DisplayName("Постоянная Капрекара")
    void Task6() {
        int numForK1 = 9865;
        int expRes1 = 2;

        int numForK2 = 1012;
        int expRes2 = 4;

        int result1 = countK(numForK1);
        int result2 = countK(numForK2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг")
    void Task7() {
        int n1 = 8;
        int shift1 = 3;
        int expRes1 = 1;

        int n2 = 16;
        int shift2 = 4;
        int expRes2 = 8;

        int result1 = rotateRight(n1, shift1);
        int result2 = rotateLeft(n2, shift2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }

    @Test
    @DisplayName("Кони на доске")
    void Task8() {
        int[][] board1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0}
        };
        boolean expRes1 = true;

        int[][] board2 = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };
        boolean expRes2 = false;

        boolean result1 = knightBoardCapture(board1);
        boolean result2 = knightBoardCapture(board2);

        assertThat(result1).isEqualTo(expRes1);
        assertThat(result2).isEqualTo(expRes2);
    }
}
