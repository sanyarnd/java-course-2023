package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Option+Enter to fix.
// Shift+F10 to run.
// Shift+F9 to debug
// Ctrl+F8 to add breakpoint
public final class Tasks {
    private Tasks() {
    }

    // Task 0
    private final static Logger LOGGER = LogManager.getLogger();

    // Task 1
    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String str) {
        var time = str.split(":");
        var mm = Integer.parseInt(time[0]);
        var ss = Integer.parseInt(time[1]);

        if (ss > 59) {
            return -1;
        }
        return mm * 60 + ss;
    }

    // Task 2
    @SuppressWarnings("MagicNumber")
    public static int countDigits(int num) {
        int count = 1;
        int n = num;
        while (n > 9) {
            n /= 10;
            count++;
        }
        return count;
    }

    // Task 3
    @SuppressWarnings("MagicNumber")
    public static boolean isNestable(int[][] table) {
        return Arrays.stream(table[0]).min().getAsInt() > Arrays.stream(table[1]).min().getAsInt()
                && Arrays.stream(table[0]).max().getAsInt() < Arrays.stream(table[1]).max().getAsInt();
    }

    // Task 4
    @SuppressWarnings("MagicNumber")
    public static String fixString(String str) {
        char[] chars = str.toCharArray();
        int iter = (str.length() % 2 == 1) ? str.length() - 1 : str.length();
        for (int i = 0; i < iter; i += 2) {
            char tmp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = tmp;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (char c : chars) {
            strBuilder.append(c);
        }
        String s = strBuilder.toString();
        return s;
    }

    // Task 5
    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int num) {
        String str = Integer.toString(num);
        char[] chars = str.toCharArray();
        // полином?
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                break;
            } else if (i == chars.length / 2 - 1) {
                return true;
            } // 1 способ выхода
        }
        // обработка, если вдруг число цифр нечетное (создаем end символ, кот потом прибавим)
        int iter;
        String end = "";
        if (str.length() % 2 == 1) {
            iter = str.length() - 1;
            end = String.valueOf(chars[chars.length - 1]);
        } else {
            iter = str.length();
        }
        // суммирование по паре цифр
        str = "";
        for (int j = 0; j < iter; j += 2) {
            str += String.valueOf(Integer.parseInt(String.valueOf(chars[j]))
                    + Integer.parseInt(String.valueOf(chars[j + 1])));
        }
        str += end; // вот и прибавление кончика
        if (str.length() < 2) {
            return false; // это если в результате меньше 2х цифр
        } else {
            return isPalindromeDescendant(Integer.parseInt(str)); // рекурсия иначе
        }
    }

    // Task 6
    @SuppressWarnings("MagicNumber")
    public static int countK(int n) {
        int num = n;
        if (num == 6174) {
            return 0;
        }
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);

        int ud = 0;
        int du = 0;
        int incr = 1;
        for (int i = 0; i < 4; i++) {
            ud += incr * digits[i];
            du += incr * digits[3 - i];
            incr *= 10;
        }

        return countK(ud - du) + 1;
    }

    // Task 7
    @SuppressWarnings("MagicNumber")
    public static int rotateLeft(int x, int count) {
        char[] chars = Integer.toBinaryString(x).toCharArray();
        for (int i = 0; i < count; i++) {
            char tmp = chars[0];
            for (int j = 0; j < chars.length - 1; j++) {
                chars[j] = chars[j + 1];
            }
            chars[chars.length - 1] = tmp;
        }
        return Integer.parseInt(new String(chars), 2);
    }

    public static int rotateRight(int x, int count) {
        char[] chars = Integer.toBinaryString(x).toCharArray();
        for (int i = 0; i < count; i++) {
            char tmp = chars[chars.length - 1];
            for (int j = chars.length - 1; j > 0; j--) {
                chars[j] = chars[j - 1];
            }
            chars[0] = tmp;
        }
        return Integer.parseInt(new String(chars), 2);
    }

    // Task 8
    @SuppressWarnings("MagicNumber")
    private static boolean isValidPosition(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] table) {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (table[i][j] == 1) {
                    int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

                    for (int[] move : moves) {
                        int ni = i + move[0];
                        int nj = j + move[1];

                        if (isValidPosition(ni, nj) && table[ni][nj] == 1) {
                            return false;
                        }
                    }
                    /*if (j + 2 < 8) {
                        if (table[i - 1][j + 2] == 1 || table[i + 1][j + 2] == 1) {
                            return false;
                        }
                    }
                    if (j - 2 > 0) {
                        if (table[i - 1][j - 2] == 1 || table[i + 1][j - 2] == 1) {
                            return false;
                        }
                    }
                    if (i + 2 < 8) {
                        if (table[i + 2][j + 1] == 1 || table[i + 2][j - 1] == 1) {
                            return false;
                        }
                    }
                    if (i - 2 > 0) {
                        if (table[i - 2][j + 1] == 1 || table[i - 2][j - 1] == 1) {
                            return false;
                        }
                    }*/
                }
            }
        }
        return true;
    }

    /*public static void main(String[] args) {
        LOGGER.info("Hello world!");
        System.out.println(minutesToSeconds("05:39"));
        System.out.println(countDigits(100));
        int[][] table = {{1, 2, 3, 4}, {2, 3}};
        System.out.println(isNestable(table));
        System.out.println(fixString("hTsii  s aimex dpus rtni.g"));
        System.out.println(isPalindromeDescendant(12321));
        System.out.println(countK(6174));
        System.out.println(rotateRight(8, 1));
        System.out.println(rotateLeft(17, 2));
//        int [][] B = {
//                {0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 1, 0, 1, 0},
//                {0, 1, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 1, 0, 0, 0}
//        };
//        int [][] B = {
//                {1, 0, 1, 0, 1, 0, 1, 0},
//                {0, 1, 0, 1, 0, 1, 0, 1},
//                {0, 0, 0, 0, 1, 0, 1, 0},
//                {0, 0, 1, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 1, 0, 1, 0},
//                {0, 0, 0, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 1, 0, 1, 0},
//                {0, 0, 0, 1, 0, 1, 0, 1}
//        };
        int[][] B = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(knightBoardCapture(B));
    }*/
}
