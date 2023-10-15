package org.lisi4ka.tasks;


public class Task8 {
    public static Boolean task8(String inputs) {
        String[] horizontal = inputs.split(":");
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String[] horizontalSplit = horizontal[i].split(" ");
            for (int j = 0; j < 8; j++) {
                board[i][j] = Integer.parseInt(horizontalSplit[j]);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                try {
                    if (board[i + 2][j + 1] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i + 2][j - 1] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i + 1][j + 2] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i + 1][j - 2] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i - 1][j + 2] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i - 1][j - 2] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i - 2][j + 1] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                try {
                    if (board[i - 2][j - 1] == 1) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return true;
    }
}
