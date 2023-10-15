package edu.hw1;

public class Task8 {
    private Task8() {
    }
    public static boolean knightBoardCapture(int[][] board) {
        int[][] moves = {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : moves) {
                        int newRow = i + move[0];
                        int newCol = j + move[1];
                        if (isValidMove(newRow, newCol, board.length, board[i].length) && board[newRow][newCol] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
