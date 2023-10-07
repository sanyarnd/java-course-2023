package edu.hw1;

public class Task3_InsertedArray {
    public static boolean isInsertable(int[] arr1, int[] arr2){
        if(arr1.length == 0 || arr2.length == 0)
            return false;
        int min1, min2, max1, max2;

        min1 = min2 = Integer.MAX_VALUE;
        max1 = max2 = Integer.MIN_VALUE;

        for (int var : arr1) {
            min1 = Math.min(var, min1);
            max1 = Math.max(var, max1);
        }

        for (int var : arr2) {
            min2 = Math.min(var, min2);
            max2 = Math.max(var, max2);
        }

        return min1 > min2 && max1 < max2;
    }
}
