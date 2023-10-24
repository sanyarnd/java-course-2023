package edu.hw1;

public class Task8 {
    private Task8() {

    }

    public static boolean knightBoardCapture(int[][] arr) {
        int size = arr.length; // 8x8
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 1) {
                    if (!isHorseCanEatAnotherHorse(arr, i, j, size)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isHorseCanEatAnotherHorse(int[][] arr, int i, int j, int size) {
        boolean condition1 = ((i < 2) || (j < 1) || (arr[i - 2][j - 1] != 1));
        boolean condition2 = ((i < 1) || (j < 2) || (arr[i - 1][j - 2] != 1));
        boolean condition3 = ((i < 2) || (j > size - 2) || (arr[i - 2][j + 1] != 1));
        boolean condition4 = ((i < 1) || (j > size - 3) || (arr[i - 1][j + 2] != 1));
        boolean condition5 = ((i > size - 3) || (j < 1) || (arr[i + 2][j - 1] != 1));
        boolean condition6 = ((i > size - 2) || (j < 2) || (arr[i + 1][j - 2] != 1));
        boolean condition7 = ((i > size - 3) || (j > size - 2) || (arr[i + 2][j + 1] != 1));
        boolean condition8 = ((i > size - 2) || (j > size - 3) || (arr[i + 1][j + 2] != 1));
        return condition1 && condition2 && condition3 && condition4
            && condition5 && condition6 && condition7 && condition8;
    }
}
