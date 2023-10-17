package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

//    public static void main(String[] args) {}

    public static boolean isNestable(int[] targetArr, int[] destinationArray) {
        // эти случаи не прописаны в услових задания, поэтому вот так
        if (targetArr.length < 2 || destinationArray.length < 2) {
            return false;
        }

        int targetArrMaxVal = Arrays.stream(targetArr).max().getAsInt();
        int targetArrMinVal = Arrays.stream(targetArr).min().getAsInt();
        int destinationArrayMaxVal = Arrays.stream(destinationArray).max().getAsInt();
        int destinationArrayMinVal = Arrays.stream(destinationArray).min().getAsInt();

        // хотя скобки тут и не нужны, но, думаю, с ними лучше читается и смотрится выражение
        return (targetArrMaxVal < destinationArrayMaxVal) && (targetArrMinVal > destinationArrayMinVal);
    }
}
