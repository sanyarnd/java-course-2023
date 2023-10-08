package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    private static final int BOARD_SIZE = 8;
    private static final int MOVE = 2;

    public static boolean isValidMove(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

    public static boolean canKnightCapture(int[][] board, int x, int y) {
        int[][] moves = {// all possible knight moves
            {-MOVE, -1}, {-MOVE, 1}, {-1, -MOVE}, {-1, MOVE},
            {1, -MOVE}, {1, MOVE}, {MOVE, -1}, {MOVE, 1}
        };

        for (int[] move : moves) { // try out different moves
            int newX = x + move[0];
            int newY = y + move[1];
            if (isValidMove(newX, newY) && board[newX][newY] == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) { // traverse
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1 && canKnightCapture(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
