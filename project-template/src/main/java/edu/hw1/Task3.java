package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        int min1 = a1[0];
        int max1 = a1[0];
        int min2 = a2[0];
        int max2 = a2[0];
        for (int i=1;i<a1.length;i++) {
            if (a1[i] < min1) {
                min1 = a1[i];
            }
            if (a1[i] > max1) {
                max1 = a1[i];
            }
        }
        for (int i=1;i<a2.length;i++) {
            if (a2[i] < min2) {
                min2 = a2[i];
            }
            if (a2[i] > max2) {
                max2 = a2[i];
            }
        }
        if ((min1 > min2) && (max1 < max2)) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }
}
