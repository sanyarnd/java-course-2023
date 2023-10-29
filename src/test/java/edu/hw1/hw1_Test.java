package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class hw1_Test {
    @Test
    @DisplayName("Длина видео. Тест 1")
    void minutesToSeconds1() {
        // given
        String str = "01:00";
        // when
        int ans = 60;
        int res = Tasks.minutesToSeconds(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Длина видео. Тест 2")
    void minutesToSeconds2() {
        // given
        String str = "13:56";
        // when
        int ans = 836;
        int res = Tasks.minutesToSeconds(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Длина видео. Тест 3")
    void minutesToSeconds3() {
        // given
        String str = "10:60";
        // when
        int ans = -1;
        int res = Tasks.minutesToSeconds(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Количество цифр. Тест 1")
    void countDigits1() {
        // given
        int num = 4666;
        // when
        int ans = 4;
        int res = Tasks.countDigits(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Количество цифр. Тест 2")
    void countDigits2() {
        // given
        int num = 544;
        // when
        int ans = 3;
        int res = Tasks.countDigits(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Количество цифр. Тест 3")
    void countDigits3() {
        // given
        int num = 0;
        // when
        int ans = 1;
        int res = Tasks.countDigits(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Вложенный массив. Тест 1")
    void isNestable1() {
        // given
        int[][] A = {{1, 2, 3, 4}, {0, 6}};
        // when
        boolean ans = true;
        boolean res = Tasks.isNestable(A);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Вложенный массив. Тест 2")
    void isNestable2() {
        // given
        int[][] A = {{3, 1}, {4, 0}};
        // when
        boolean ans = true;
        boolean res = Tasks.isNestable(A);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Вложенный массив. Тест 3")
    void isNestable3() {
        // given
        int[][] A = {{9, 9, 8}, {8, 9}};
        // when
        boolean ans = false;
        boolean res = Tasks.isNestable(A);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Вложенный массив. Тест 4")
    void isNestable4() {
        // given
        int[][] A = {{1, 2, 3, 4}, {2, 3}};
        // when
        boolean ans = false;
        boolean res = Tasks.isNestable(A);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Сломанная строка. Тест 1")
    void fixString1() {
        // given
        String str = "123456";
        // when
        String ans = "214365";
        String res = Tasks.fixString(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Сломанная строка. Тест 2")
    void fixString2() {
        // given
        String str = "hTsii  s aimex dpus rtni.g";
        // when
        String ans = "This is a mixed up string.";
        String res = Tasks.fixString(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Сломанная строка. Тест 3")
    void fixString3() {
        // given
        String str = "badce";
        // when
        String ans = "abcde";
        String res = Tasks.fixString(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Особый палиндром. Тест 1")
    void isPalindromeDescendant1() {
        // given
        int num = 11211230;
        // when
        boolean ans = true;
        boolean res = Tasks.isPalindromeDescendant(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Особый палиндром. Тест 2")
    void isPalindromeDescendant2() {
        // given
        int num = 13001120;
        // when
        boolean ans = true;
        boolean res = Tasks.isPalindromeDescendant(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Особый палиндром. Тест 3")
    void isPalindromeDescendant3() {
        // given
        int num = 23336014;
        // when
        boolean ans = true;
        boolean res = Tasks.isPalindromeDescendant(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Особый палиндром. Тест 4")
    void isPalindromeDescendant4() {
        // given
        int num = 11;
        // when
        boolean ans = true;
        boolean res = Tasks.isPalindromeDescendant(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Постоянная Капрекара. Тест 1")
    void countK1() {
        // given
        int num = 6621;
        // when
        int ans = 5;
        int res = Tasks.countK(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Постоянная Капрекара. Тест 2")
    void countK2() {
        // given
        int num = 6554;
        // when
        int ans = 4;
        int res = Tasks.countK(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Постоянная Капрекара. Тест 3")
    void countK3() {
        // given
        int num = 1234;
        // when
        int ans = 3;
        int res = Tasks.countK(num);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Циклический битовый сдвиг. Тест 1")
    void rotateRight1() {
        // given
        int num = 8;
        int shift = 1;
        // when
        int ans = 4;
        int res = Tasks.rotateRight(num, shift);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Циклический битовый сдвиг. Тест 2")
    void rotateLeft2() {
        // given
        int num = 16;
        int shift = 1;
        // when
        int ans = 1;
        int res = Tasks.rotateLeft(num, shift);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Циклический битовый сдвиг. Тест 3")
    void rotateLeft3() {
        // given
        int num = 17;
        int shift = 2;
        // when
        int ans = 6;
        int res = Tasks.rotateLeft(num, shift);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Кони на доске. Тест 1")
    void knightBoardCapture1() {
        // given
        int [][] B = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
        };
        // when
        boolean ans = true;
        boolean res = Tasks.knightBoardCapture(B);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Кони на доске. Тест 2")
    void knightBoardCapture2() {
        // given
        int [][] B = {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
        };
        // when
        boolean ans = false;
        boolean res = Tasks.knightBoardCapture(B);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Кони на доске. Тест 3")
    void knightBoardCapture3() {
        // given
        int[][] B = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        // when
        boolean ans = false;
        boolean res = Tasks.knightBoardCapture(B);
        // then
        assertThat(res).isEqualTo(ans);
    }
}
