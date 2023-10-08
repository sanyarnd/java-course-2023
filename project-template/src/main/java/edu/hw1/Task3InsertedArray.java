package edu.hw1;

final class Task3InsertedArray {
    private Task3InsertedArray() {
    }

    public static boolean isInsertable(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int item : arr1) {
            min1 = Math.min(item, min1);
            max1 = Math.max(item, max1);
        }

        for (int item : arr2) {
            min2 = Math.min(item, min2);
            max2 = Math.max(item, max2);
        }

        return min1 > min2 && max1 < max2;
    }
}
