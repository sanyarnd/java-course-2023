package edu.hw1;

public class task8 {
    public static boolean isGood(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    static int[] dx = new int[] {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = new int[] {2, -2, 1, -1, 2, -2, 1, -1};
    public static boolean knightBoardCapture(final int[][] a) {
        int n = 8, m = 8;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == 1) {
                    for (int w = 0; w < 8; ++w) {
                        int vx = i + dx[w], vy = j + dy[w];
                        if (isGood(vx, vy) && a[vx][vy] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
