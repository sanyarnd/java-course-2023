package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task8 {
    private static final Logger LOGGER = LogManager.getLogger();
    private final static int[][] MOVES = {
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
        {1, 2},
        {-1, 2},
        {1, -2},
        {-1, -2},
    };


    public static boolean isKnightTakes(int[][] board) {
        int board_len = board.length;
        for (int i = 0; i < board_len; i++) {
            for (int j = 0; j < board_len; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < board_len; k++) {
                        if (i + MOVES[k][0] > 0 &&
                            i + MOVES[k][0] < board_len &&
                            j + MOVES[k][1] > 0 &&
                            j + MOVES[k][1] < board_len) {
                            if (board[i + MOVES[k][0]][j + MOVES[k][1]] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LOGGER.info(MOVES[3][0]);

        LOGGER.info(isKnightTakes(
            new int[][] {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}}));

    }
}
