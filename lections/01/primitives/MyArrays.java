package tinkoff.primitives;

import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        int[] v1 = new int[5];

        v1[0] = 1;
        v1[1] = 2;

        System.out.println(v1);
        System.out.println(Arrays.toString(v1));


        int[] v2 = new int[] {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(v2));
    }
}
