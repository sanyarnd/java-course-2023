package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task9Test {

    @Test
    void testIsValidMove() {
        assertThat(Task9.isValidMove(0, 0)).isTrue();
        assertThat(Task9.isValidMove(8, 8)).isFalse();
        assertThat(Task9.isValidMove(-1, 3)).isFalse();
        assertThat(Task9.isValidMove(3, -1)).isFalse();
    }

    @Test
    void testCanKnightCapture() {
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        assertThat(Task9.canKnightCapture(board, 3, 3)).isTrue();
        assertThat(Task9.canKnightCapture(board, 0, 1)).isFalse();
        assertThat(Task9.canKnightCapture(board, 2, 6)).isTrue();
    }

    @Test
    void testKnightBoardCapture() {
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

        assertThat(Task9.knightBoardCapture(board1)).isTrue();
        assertThat(Task9.knightBoardCapture(board2)).isFalse();
    }

}
