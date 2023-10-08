package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Task9Test {

    @ParameterizedTest
    @MethodSource("isValidMoveArguments")
    @DisplayName("Проверка метода isValidMove")
    void testIsValidMove(int x, int y, boolean expected) {
        assertThat(Task9.isValidMove(x, y)).isEqualTo(expected);
    }

    private static Stream<Arguments> isValidMoveArguments() {
        return Stream.of(
            Arguments.of(0, 0, true),
            Arguments.of(8, 8, false),
            Arguments.of(-1, 3, false),
            Arguments.of(3, -1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("canKnightCaptureArguments")
    @DisplayName("Проверка метода canKnightCapture")
    void testCanKnightCapture(int[][] board, int x, int y, boolean expected) {
        assertThat(Task9.canKnightCapture(board, x, y)).isEqualTo(expected);
    }

    private static Stream<Arguments> canKnightCaptureArguments() {
        return Stream.of(
            Arguments.of(getBoard1(), 3, 3, true),
            Arguments.of(getBoard1(), 0, 1, false),
            Arguments.of(getBoard1(), 2, 6, true),
            Arguments.of(getBoard2(), 3, 3, false),
            Arguments.of(getBoard2(), 1, 1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("knightBoardCaptureArguments")
    @DisplayName("Проверка метода knightBoardCapture")
    void testKnightBoardCapture(int[][] board, boolean expected) {
        assertThat(Task9.knightBoardCapture(board)).isEqualTo(expected);
    }

    private static Stream<Arguments> knightBoardCaptureArguments() {
        return Stream.of(
            Arguments.of(getBoard1(), true),
            Arguments.of(getBoard2(), false)
        );
    }

    private static int[][] getBoard1() {
        return new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
    }

    private static int[][] getBoard2() {
        return new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
    }
}
