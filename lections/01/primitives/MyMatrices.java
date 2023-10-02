package tinkoff.primitives;

import java.util.Arrays;

public class MyMatrices {
    public static void main(String[] args) {
        int[][] m1 = new int[5][5];
        m1[0][0] = 1;
        m1[0][1] = 1;
        m1[0][2] = 1;
        m1[0][3] = 1;
        m1[0][4] = 1;

        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m1[0]));

        int[][] m2 = new int[5][];
        m2[0] = new int[1];
        m2[1] = new int[2];
        m2[2] = new int[3];
        m2[3] = new int[4];
        m2[4] = new int[5];

        System.out.println();
        System.out.println(Arrays.toString(m2[0]));
        System.out.println(Arrays.toString(m2[1]));

        int[][] m3 = new int[][] {
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 6}
        };
    }
}
