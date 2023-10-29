package edu.hw1;

public class Task8 {
    public static boolean knightBoardCapture(int[][] board) {
        boolean[][] mask = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mask[i][j] = true;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1 && !mask[i][j]) {
                    return false;
                }

                if (board[i][j] == 1) {
                    if (i + 1 < 8) {
                        if (j - 2 > 0)
                            mask[i + 1][j - 2] = false;
                        if (j + 2 < 8)
                            mask[i + 1][j + 2] = false;
                    }
                    if (i + 2 < 8) {
                        if (j - 1 > 0)
                            mask[i + 2][j - 1] = false;
                        if (j + 1 < 8)
                            mask[i + 2][j + 1] = false;
                    }
                }
            }
        }

        return true;
    }
}
