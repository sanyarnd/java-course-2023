package edu.hw1;

import java.util.Arrays;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        return Arrays.stream(a1).min().getAsInt() > Arrays.stream(a2).min().getAsInt() &&
            Arrays.stream(a1).max().getAsInt() < Arrays.stream(a2).max().getAsInt();
    }
}
