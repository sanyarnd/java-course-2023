package edu.hw1;

import java.util.logging.Logger;

@SuppressWarnings({"uncommentedmain", "checkstyle:magicnumber"})
public final class Task9 {
    private Task9() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task9.class.getName());

    public static void main(String[] args) {
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

        LOGGER.info(String.valueOf(knightBoardCapture(board1))); // true
        LOGGER.info(String.valueOf(knightBoardCapture(board2))); // false
    }

    public static boolean isValidMove(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public static boolean canKnightCapture(int[][] board, int x, int y) {
        int[][] moves = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (isValidMove(newX, newY) && board[newX][newY] == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1 && canKnightCapture(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
