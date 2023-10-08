package edu.hw1;

final class Task8ChessKnights {
    private Task8ChessKnights() {
    }

    final static public int MAX_SQUARE_NUMBER = 8;
    final static public int HIGH_EDGE = 7;
    final static public int LOW_EDGE = 0;

    public static boolean isBoardValid(int[][] board) {
        if (board.length != MAX_SQUARE_NUMBER) {
            return false;
        }
        for (int i = 0; i < MAX_SQUARE_NUMBER; i++) {
            if (board[i].length != MAX_SQUARE_NUMBER) {
                return false;
            }
            for (int j = 0; j < MAX_SQUARE_NUMBER; j++) {
                if (board[i][j] != 1 && board[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isKnightBoardCapture(int[][] board) {
        //ALSO RETURN FALSE IF THE DATA IS INCORRECT
        if (!isBoardValid(board)) {
            return false;
        }
        //moving of knight
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        for (int i = 0; i < MAX_SQUARE_NUMBER; i++) {
            for (int j = 0; j < MAX_SQUARE_NUMBER; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < dx.length; k++) {
                        int moveX = i + dx[k];
                        int moveY = j + dy[k];
                        if (LOW_EDGE <= moveY && moveY <= HIGH_EDGE
                            && LOW_EDGE <= moveX && moveX <= HIGH_EDGE
                            && (board[moveY][moveX] == 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
