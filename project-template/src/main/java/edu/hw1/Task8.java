package edu.hw1;

import static java.lang.Math.abs;

public class Task8 {
    static final int ROWS = 8;
    static final int COLS = 8;

    private Task8() {
    }

    public static void main(String[] args) {
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 1) {
                    for (int k = -2; k < 3; ++k) {
                        for (int c = -2; c < 3; ++c) {
                            if (abs(k) + abs(c) == 3) {
                                int newRow = i + k;
                                int newCol = j + c;

                                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS
                                    && board[newRow][newCol] == 1) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
