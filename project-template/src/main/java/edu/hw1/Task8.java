package edu.hw1;

public class Task8 {
    private Task8() {

    }

    public static boolean knightBoardCapture(int[][] arr) {
        int size = arr.length; // 8x8
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 1) {
                    if (!checkHorse(arr, i, j, size)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkHorse(int[][] arr, int i, int j, int size) {
        return ((i < 2) || (j < 1) || (arr[i - 2][j - 1] != 1))
            && ((i < 1) || (j < 2) || (arr[i - 1][j - 2] != 1))
            && ((i < 2) || (j > size - 2) || (arr[i - 2][j + 1] != 1))
            && ((i < 1) || (j > size - 3) || (arr[i - 1][j + 2] != 1))
            && ((i > size - 3) || (j < 1) || (arr[i + 2][j - 1] != 1))
            && ((i > size - 2) || (j < 2) || (arr[i + 1][j - 2] != 1))
            && ((i > size - 3) || (j > size - 2) || (arr[i + 2][j + 1] != 1))
            && ((i > size - 2) || (j > size - 3) || (arr[i + 1][j + 2] != 1));
    }
}
