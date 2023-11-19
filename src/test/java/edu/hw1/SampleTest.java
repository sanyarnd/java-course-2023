package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw1.Task1.minutesToSeconds;
import static edu.hw1.Task2.countDigits;
import static edu.hw1.Task3.isNestable;
import static edu.hw1.Task4.fixString;
import static edu.hw1.Task5.isPalindromeDescendant;
import static edu.hw1.Task6.countK;
import static edu.hw1.Task7.rotateRight;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task8.knightBoardCapture;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.params.provider.Arguments;

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

    @ParameterizedTest
    @MethodSource("data_for_minutesToSeconds")
    @DisplayName("Длина видео")
    void minutesToSeconds_validInputString_successTest(String input, int res) {
        int result1 = minutesToSeconds(input);

        assertThat(result1).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_minutesToSeconds() {
        return Stream.of(
            Arguments.of("01:60", -1),
            Arguments.of("01:59", 119)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_countDigits")
    @DisplayName("Количество цифр")
    void countDigits_validInputNumbers_successTest(int input, int res) {
        int result1 = countDigits(input);

        assertThat(result1).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_countDigits() {
        return Stream.of(
            Arguments.of(-1, 1),
            Arguments.of(999999999, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_isNestable")
    @DisplayName("Вложенный массив")
    void isNestable_validInputNumbersMas_successTest(int[] array1, int[] array2, boolean res) {
        boolean result = isNestable(array1, array2);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_isNestable() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 1, 1}, new int[]{1, 1}, false),
            Arguments.of(new int[]{8, 8, 8, 8}, new int[]{8, 8, 9, 9, 7}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_fixString")
    @DisplayName("Сломанная строка")
    void fixString_validInputString_successTest(String input, String res) {
        char[] arr = input.toCharArray();
        char[] expRes = res.toCharArray();

        char[] result = fixString(arr);

        assertThat(result).isEqualTo(expRes);
    }

    private static Stream<Arguments> data_for_fixString() {
        return Stream.of(
            Arguments.of("1111", "1111"),
            Arguments.of("ebn ci e", "be nice ")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_isPalindromeDescendant")
    @DisplayName("Особый палиндром")
    void isPalindromeDescendant_validInputNumbers_successTest(int input, boolean res) {
        boolean result = isPalindromeDescendant(input);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> data_for_isPalindromeDescendant() {
        return Stream.of(
            Arguments.of(112232211, true),
            Arguments.of(696969, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_countK")
    @DisplayName("Постоянная Капрекара")
    void countK_validInputNumbers_successTest(int input, int res) {
        int result = countK(input);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> data_for_countK() {
        return Stream.of(
            Arguments.of(9865, 2),
            Arguments.of(1012, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_rotate")
    @DisplayName("Циклический битовый сдвиг")
    void rotate_validInputNumbersAndShifts_successTest(int input, int shift, int res, boolean rotate) {
        int result = 0;

        if(rotate) {
            result = rotateRight(input, shift);
        }else {
            result = rotateLeft(input, shift);
        }

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_rotate() {
        return Stream.of(
            Arguments.of(8, 3, 1, true),
            Arguments.of(16, 4, 8, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_knightBoardCapture")
    @DisplayName("Кони на доске")
    void knightBoardCapture_validInputNumbersAndShifts_successTest(int[][] input, boolean res) {
        boolean result = knightBoardCapture(input);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_knightBoardCapture() {
        return Stream.of(
            Arguments.of(new int[][]{
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0}
        }, true),
            Arguments.of(new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        }, false)
        );
    }
}
