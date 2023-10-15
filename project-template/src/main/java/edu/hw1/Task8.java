package edu.hw1;

public class Task8 {
    public static boolean knightBoardCapture(int[][] arr) {
        int size = arr.length; // 8x8
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                if (arr[i][j] == 1) {
                    if ((i >= 2) && (j >= 1) && (arr[i - 2][j - 1] == 1)) {
                        System.out.println(false);
                        return false;
                    }
                    if ((i >= 1) && (j >= 2) && (arr[i - 1][j - 2] == 1)) {
                        System.out.println(false);
                        return false;
                    }

                    if ((i >= 2) && (j <= size-2) && (arr[i -2][j + 1] == 1)) {
                        System.out.println(false);
                        return false;
                    }
                    if ((i >= 1) && (j <= size-3) && (arr[i -1][j + 2] == 1)) {
                        System.out.println(false);
                        return false;
                    }

                    if ((i <= size-3) && (j >= 1) && (arr[i + 2][j - 1] == 1)) {
                        System.out.println(false);
                        return false;
                    }
                    if ((i <= size-2) && (j >= 2) && (arr[i + 1][j - 2] == 1)) {
                        System.out.println(false);
                        return false;
                    }

                    if ((i <= size-3) && (j <= size-2) && (arr[i + 2][j + 1] == 1)) {
                        System.out.println(false);
                        return false;
                    }
                    if ((i <= size-2) && (j <= size-3) && (arr[i + 1][j + 2] == 1)) {
                        System.out.println(false);
                        return false;
                    }
                }
            }
        }
        System.out.println(true);
        return true;
    }
}
