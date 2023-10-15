package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    //task1
    public static int minutesToSeconds(String length) {
        String[] parts = length.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        if (seconds >= 60){
            return -1;
        }
        int totalSeconds = minutes * 60 + seconds;
        return totalSeconds;
    }

    //task2
    public static int countDigits(int number) {
        int count = 0;
        if(number == 0 ){
            count++;
            return count;
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }
        return count;
    }

    //task3
    public static boolean isNestable(int[] arr1, int[] arr2){
        int minArr1 = Integer.MAX_VALUE;
        int maxArr1 = Integer.MIN_VALUE;
        int minArr2 = Integer.MAX_VALUE;
        int maxArr2 = Integer.MIN_VALUE;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] > maxArr1){
                maxArr1 = arr1[i];
            }
            if(arr1[i] < minArr1){
                minArr1 = arr1[i];
            }
        }

        for(int i = 0; i < arr2.length; i++){
            if(arr2[i] > maxArr2){
                maxArr2 = arr2[i];
            }
            if(arr2[i] < minArr2){
                minArr2 = arr2[i];
            }
        }

        if((minArr1 > minArr2) && (maxArr1 < maxArr2)){
            return true;
        }
        return false;
    }

    //task4
    public static char[] fixString(char[] str){
        if(str.length % 2 == 0) {
            for (int i = 0; i < str.length; i += 2) {
                char tmp = str[i];
                str[i] = str[i + 1];
                str[i + 1] = tmp;
            }
        } else{
            for (int i = 0; i < str.length - 1; i += 2) {
                char tmp = str[i];
                str[i] = str[i + 1];
                str[i + 1] = tmp;
            }
        }
        return str;
    }

    //task5
    public static boolean isPalindromeDescendant(int number){
        String numberString = String.valueOf(number);
        while(numberString.length() > 1){
            int left = 0;
            int right = numberString.length() - 1;
            int cnt = 0;

            while (left < right) {
                if (numberString.charAt(left) == numberString.charAt(right)) {
                    cnt++;
                }
                left++;
                right--;
            }

            if(cnt == numberString.length() / 2){
                return true;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < numberString.length() - 1; i+=2) {
                int digit1 = Character.getNumericValue(numberString.charAt(i));
                int digit2 = Character.getNumericValue(numberString.charAt(i + 1));
                sb.append(digit1 + digit2);
            }

            numberString = sb.toString();
        }
        return false;
    }

    //task6
    public static int countK(int number){
        if (number == 6174) {
            return 0;
        }

        String numberString = String.valueOf(number);
        if (numberString.length() < 4) {
            numberString = String.format("%04d", number);
        }

        char[] digits = numberString.toCharArray();
        Arrays.sort(digits);
        int ascendingOrder = Integer.parseInt(new String(digits));

        int left = 0;
        int right = digits.length - 1;

        while (left < right) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;

            left++;
            right--;
        }
        int descendingOrder = Integer.parseInt(new String(digits));

        int diff = descendingOrder - ascendingOrder;

        return 1 + countK(diff);
    }

    //task7
    public static int rotateLeft(int n, int shift) {
        String bits = Integer.toBinaryString(n);
        String toShift = bits.substring(shift) + bits.substring(0, shift);

        return Integer.parseInt(toShift, 2);
    }

    public static int rotateRight(int n, int shift) {
        String bits = Integer.toBinaryString(n);
        String toShift = bits.substring(bits.length() - shift) + bits.substring(0, bits.length() - shift);

        return Integer.parseInt(toShift, 2);
    }

    //task8
    public static boolean knightBoardCapture(int[][] board) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : moves) {
                        int row = i + move[0];
                        int col = j + move[1];

                        if ((row >= 0 && row < board.length && col >= 0 && col < board.length) && board[row][col] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        //task0
//        LOGGER.info("Hello and welcome!");
//        for (int i = 0; i <= 2; i++) {
//
//            LOGGER.info("i = {}", i);
//        }

        //task1
        String length = "01:00";
        int totalSeconds = minutesToSeconds(length);
        System.out.println(totalSeconds);
        length = "13:56";
        totalSeconds = minutesToSeconds(length);
        System.out.println(totalSeconds);
        length = "10:60";
        totalSeconds = minutesToSeconds(length);
        System.out.println(totalSeconds);

        System.out.println();
        //task2
        int number = 4666;
        int totalDigits = countDigits(number);
        System.out.println(totalDigits);
        number = 544;
        totalDigits = countDigits(number);
        System.out.println(totalDigits);
        number = 0;
        totalDigits = countDigits(number);
        System.out.println(totalDigits);

        System.out.println();
        //task3
        int[] array1_1 = {1, 2, 3, 4};
        int[] array2_1 = {0, 6};
        System.out.println(isNestable(array1_1, array2_1));
        int[] array1_2 = {3, 1};
        int[] array2_2 = {4, 0};
        System.out.println(isNestable(array1_2, array2_2));
        int[] array1_3 = {9, 9, 8};
        int[] array2_3 = {8, 9};
        System.out.println(isNestable(array1_3, array2_3));
        int[] array1_4 = {1, 2, 3, 4};
        int[] array2_4 = {2, 3};
        System.out.println(isNestable(array1_4, array2_4));

        System.out.println();
        //task4
        String str = "123456";
        char[] arr = str.toCharArray();
        System.out.println(fixString(arr));
        str = "hTsii  s aimex dpus rtni.g";
        arr = str.toCharArray();
        System.out.println(fixString(arr));
        str = "badce";
        arr = str.toCharArray();
        System.out.println(fixString(arr));

        System.out.println();
        //task5
        int num = 11211230;
        System.out.println(isPalindromeDescendant(num));
        num = 13001120;
        System.out.println(isPalindromeDescendant(num));
        num = 23336014;
        System.out.println(isPalindromeDescendant(num));
        num = 11;
        System.out.println(isPalindromeDescendant(num));

        System.out.println();
        //task6
        int numForK = 6621;
        System.out.println(countK(numForK));
        numForK = 6554;
        System.out.println(countK(numForK));
        numForK = 1234;
        System.out.println(countK(numForK));

        System.out.println();
        //task7
        int n = 8;
        int shift = 1;
        System.out.println(rotateRight(n, shift));
        n = 16;
        shift = 1;
        System.out.println(rotateLeft(n, shift));
        n = 17;
        shift = 2;
        System.out.println(rotateLeft(n, shift));

        System.out.println();
        //task8
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        System.out.println(knightBoardCapture(board));

        int[][] board1 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        System.out.println(knightBoardCapture(board1));

        int[][] board2 = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(knightBoardCapture(board2));
    }
}
