package edu.hw1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
    }

    public static boolean isNestable(int[] targetArr, int[] destinationArray) {
        int targetArrMaxVal = Arrays.stream(targetArr).max().getAsInt();
        int targetArrMinVal = Arrays.stream(targetArr).min().getAsInt();
        int destinationArrayMaxVal = Arrays.stream(destinationArray).max().getAsInt();
        int destinationArrayMinVal = Arrays.stream(destinationArray).min().getAsInt();

        if (targetArrMaxVal < destinationArrayMaxVal && targetArrMinVal > destinationArrayMinVal) {
            return true;
        }

        return false;
    }
}
