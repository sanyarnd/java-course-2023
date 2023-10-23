package edu.hw1;

public class Task8 {

    private Task8() {
    }

    public static boolean isGood(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static final int MAGICNUM = -2;
    static int[] dx = new int[] {1, 1, 2, 2, -1, -1, MAGICNUM, MAGICNUM};
    static int[] dy = new int[] {2, MAGICNUM, 1, -1, 2, MAGICNUM, 1, -1};

    public static boolean knightBoardCapture(final int[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == 1) {
                    for (int w = 0; w < dx.length; ++w) {
                        int vx = i + dx[w];
                        int vy = j + dy[w];
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
