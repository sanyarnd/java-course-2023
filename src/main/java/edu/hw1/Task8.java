package edu.hw1;

public class Task8 {

    private Task8() {
    }

    private static boolean isGood(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    final static int[] DX = new int[] {1, 1, 2, 2, -1, -1, -2, -2};
    final static int[] DY = new int[] {2, -2, 1, -1, 2, -2, 1, -1};

    public static boolean knightBoardCapture(final int[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == 1) {
                    for (int w = 0; w < DX.length; ++w) {
                        int vx = i + DX[w];
                        int vy = j + DY[w];
                        if (isGood(vx, vy, n, m) && a[vx][vy] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
