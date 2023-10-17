package edu.hw1;

public class Task8 {
    static final int ROWS = 8;
    static final int COLS = 8;

    private Task8() {
    }

//    public static void main(String[] args) {}

    public static boolean knightBoardCapture(int[][] board) {
        final int[][] knightMoves = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < knightMoves.length; ++k) {
                        int newRow = i + knightMoves[k][0];
                        int newCol = j + knightMoves[k][1];

                        if (isValidMove(newRow, newCol) && board[newRow][newCol] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
}
