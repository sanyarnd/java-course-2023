package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.OptionalInt;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        sayHi();
    }

    // #0
    public static void sayHi() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Tinkoff");
        logger.info("Привет, мир!");
    }

    // #1
    public static int minutesToSeconds(String str) {
        String[] splitedStr = str.split(":");

        int minutes = getTime(splitedStr[0]);
        int seconds = getTime(splitedStr[1]);

        return (seconds < 60 && seconds > -1) ? seconds + minutes * 60 : -1;
    }
    private static int getTime(String timeStr) {
        return Integer.parseInt(timeStr);
    }

    // #2
    public static int countDigits(int value) {
        if (value < 0) value = Math.abs(value);

        if (value < 10) return 1;
        return 1 + countDigits(value / 10);
    }

    // #3
    public static boolean isNestable(int[] a1, int[] a2) {
        return getLimitOfArray(a1, false) < getLimitOfArray(a2, false)
            && getLimitOfArray(a1, true) > getLimitOfArray(a2, true);
    }
    private static int getLimitOfArray(int[] arr, boolean min) {
        OptionalInt valueToCheck = min ? Arrays.stream(arr).min() : Arrays.stream(arr).max();
        return valueToCheck.isPresent() ? valueToCheck.getAsInt() : 0;
    }

    // #4
    public static String fixString(String str) {
        char[] charStr = str.toCharArray();

        for (int i = 0; i < charStr.length - 1; i += 2) {
            char tmp = charStr[i];
            charStr[i] = charStr[i + 1];
            charStr[i + 1] = tmp;
        }

        return new String(charStr);
    }

    // #5
    public static boolean isPalindromeDescendant(int number) {
        while (number >= 10) {
            if (isPalindrome(number)) {
                return true;
            }
            number = getDescendant(number);
        }

        return false;
    }

    private static int getDescendant(int number) {
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(number);
        for (int i = 0; i < str.length() - 1; i+=2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            int digit2 = Character.getNumericValue(str.charAt(i + 1));
            sb.append(digit1 + digit2);
        }

        if (str.length() % 2 != 0) {
            sb.append(str.charAt(str.length() - 1));
        }

        return Integer.parseInt(sb.toString());
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // #6
    public static int countK(int value) {
        if (value == 6174) {
            return 0;
        }

        return 1 + countK(sortDigitsInNumber(value, true) - sortDigitsInNumber(value, false));
    }

    private static int sortDigitsInNumber(int number, boolean reversedOrder) {
        String numberString = String.valueOf(number);

        char[] digitsArray = numberString.toCharArray();

        Arrays.sort(digitsArray);

        if (reversedOrder) {
            StringBuilder sortedNumberString = new StringBuilder(new String(digitsArray));
            sortedNumberString.reverse();
            return Integer.parseInt(sortedNumberString.toString());
        } else {
            String sortedNumberString = new String(digitsArray);

            return Integer.parseInt(sortedNumberString);
        }
    }

    // #7
    public static int rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        shift %= binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(binaryStr.length() - shift)
            + binaryStr.substring(0, binaryStr.length() - shift);
        return Integer.parseInt(rotatedBinaryStr, 2);
    }

    public static int rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        shift %= binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(shift) + binaryStr.substring(0, shift);
        return Integer.parseInt(rotatedBinaryStr, 2);
    }

    // #8
    public static boolean knightBoardCapture(int[][] board) {
        int[][] knightTurns = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    for (int[] direction : knightTurns) {
                        int row = i + direction[0];
                        int col = j + direction[1];
                        if (isValidCell(row, col, rows, cols) && board[row][col] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private static boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
