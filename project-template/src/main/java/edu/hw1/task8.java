package edu.hw1;

public class task8 {
    public static boolean knightBoardCapture(int[][] board) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : moves) {
                        int row = i + move[0];
                        int col = j + move[1];

                        if ((row >= 0 && row < board.length && col >= 0 && col < board.length) && board[row][col] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
