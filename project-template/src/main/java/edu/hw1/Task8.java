package edu.hw1;

public class Task8 {
    private static int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    private static boolean hasAdjacentOnes(int[][] board, int row, int col) {

        for (int[] move : MOVES) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if ((newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length) && board[newRow][newCol] == 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1 && hasAdjacentOnes(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
