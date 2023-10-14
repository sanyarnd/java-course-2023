package edu.hw1;

import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Math.abs;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        logInfo();
    }

    public static void logInfo() {
        LOGGER.info("Привет, мир!");
    }

    @SuppressWarnings("MagicNumber")
    public static int videoLength(String length) {
        String[] time = length.split(":");
        if (time.length == 2) {
            try {
                int secondsInMinute = 60;
                if (Integer.parseInt(time[0]) >= 0
                    && Integer.parseInt(time[1]) >= 0
                    && Integer.parseInt(time[1]) < secondsInMinute) {
                    return Integer.parseInt(time[0]) * secondsInMinute + Integer.parseInt(time[1]);
                }
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public static int digitCount(int number) {
        return number == 0 ? 1 : (int) Math.floor(Math.log10(abs(number)) + 1);
    }

    public static boolean isNestable(Integer[] nested, Integer[] container) {
        int nestedMin = Collections.min(Arrays.asList(nested));
        int nestedMax = Collections.max(Arrays.asList(nested));
        int containerMin = Collections.min(Arrays.asList(container));
        int containerMax = Collections.max(Arrays.asList(container));
        return nestedMin > containerMin && nestedMax < containerMax;
    }

    public static String stringFix(String brokenString) {
        char[] chars = brokenString.toCharArray();
        if (chars.length > 1) {
            for (int i = 0; i < chars.length - 1; i += 2) {
                char tmp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = tmp;
            }
        }
        return String.valueOf(chars);
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindrome(int number) {
        String numberCopy = String.valueOf(abs(number));
        int i = 0;
        int j = numberCopy.length() - 1;

        while (i < j) {

            if (numberCopy.charAt(i) != numberCopy.charAt(j)) {
                if (numberCopy.length() % 2 == 0) {
                    int numberDescendant = 0;
                    for (int k = 0; k < numberCopy.length(); k += 2) {
                        numberDescendant += Math.pow(10, k / 2)
                            * (numberCopy.charAt(k) - '0' + numberCopy.charAt(k + 1) - '0');
                    }
                    if (number >= 10) {
                        numberCopy = String.valueOf(numberDescendant);
                        i = -1;
                        j = numberCopy.length();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    public static int kaprekar(int number) {
        if (number == 6174 || number <= 1000 || number >= 9999) {
            return 0;
        } else {
            String stringNumber = String.valueOf(number);
            int[] num = new int[4];

            for (int i = 0; i < stringNumber.length(); i++) {
                num[i] = stringNumber.charAt(i) - '0';
            }
            Arrays.sort(num);
            String regex = "\\[|\\]|,|\\s";
            int minNum = Integer.parseInt(Arrays.toString(num).replaceAll(regex, ""));
            for (int i = 0; i < num.length / 2; i++) {
                int temp = num[i];
                num[i] = num[num.length - i - 1];
                num[num.length - i - 1] = temp;
            }
            int maxNum = Integer.parseInt(Arrays.toString(num).replaceAll(regex, ""));
            if (maxNum - minNum != 0) {
                return 1 + kaprekar(maxNum - minNum);
            } else {
                return 0;
            }
        }
    }

    public static int rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        String shiftedStr =
            binaryStr.substring(binaryStr.length() - shift) + binaryStr.substring(0, binaryStr.length() - shift);
        return Integer.parseInt(shiftedStr, 2);
    }

    public static int rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        String shiftedStr = binaryStr.substring(shift) + binaryStr.substring(0, shift);
        return Integer.parseInt(shiftedStr, 2);
    }

    public static boolean isKnightTakes(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1
                    && ((i + 1 < board.length && j + 2 < board[0].length && board[i + 1][j + 2] == 1)
                    || (i + 2 < board.length && j + 1 < board[0].length && board[i + 2][j + 1] == 1)
                    || (i + 1 < board.length && j - 2 >= 0 && board[i + 1][j - 2] == 1)
                    || (i + 2 < board.length && j - 1 >= 0 && board[i + 2][j - 1] == 1))) {
                        return false;
                }
            }
        }
        return true;
    }
}
