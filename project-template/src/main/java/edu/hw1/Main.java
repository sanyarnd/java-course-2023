package edu.hw1;
import java.util.List;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import java.util.Arrays;
import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static java.util.logging.Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static int minutesToSeconds(String time) {
        var strs = time.split(":");
        if (strs.length == 2) {
            var minutes = Integer.parseInt(strs[0]);
            var seconds = Integer.parseInt(strs[1]);
            if (seconds < 60) {
                return (minutes * 60) + seconds;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static int countDigits(long num) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static Boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0 || a2.length == 0) return false;
        var min_a1 = Arrays.stream(a1).min().getAsInt();
        var max_a1 = Arrays.stream(a1).max().getAsInt();

        var min_a2 = Arrays.stream(a2).min().getAsInt();
        var max_a2 = Arrays.stream(a2).max().getAsInt();

        return min_a1 > min_a2 && max_a1 < max_a2;
    }

    public static String fixString(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return new String(chars);
    }

    // Task 5 ----------------------------------------------------
    public static boolean isPalindromeDescendant(int num) {
        String str = Integer.toString(num);
        while (str.length() > 1) {
            if (isPalindrome(str)) {
                return true;
            }
            str = getNextDescendant(str);
        }
        return false;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String getNextDescendant(String str) {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = start; i < str.length() - 1; i += 2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));

            sb.append(sum);
            // start += 2;
            //  i = start;

        }
        return sb.toString();
    }

    // -------------------------------
    public static boolean isVerified(int n) {
        int[] digits = new int[10]; // массив для хранения количества каждой цифры
        List<Integer> num = new ArrayList<>() {
        };
        while (n != 0) {
            var a = n % 10;
            digits[a]++;
            num.add(a);
            n /= 10;
        }
        if (num.size() == 4) {
            for (int d : digits) {
                if (d == 4) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int countK(int n) {

        if (n == 6174 || !isVerified(n)) {
            return 0;
        } else {
            int[] digits = new int[4];
            for (int i = 0; i < 4; i++) {
                digits[i] = n % 10;
                n /= 10;
            }
            Arrays.sort(digits);
            int asc = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
            int desc = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
            int diff = desc - asc;
            return 1 + countK(diff);
        }
    }

    // Task 7
    public static int rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        String shifted = binaryStr.substring(shift) + binaryStr.substring(0, shift);
        return Integer.parseInt(shifted, 2);
    }

    public static int rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        String shifted =
            binaryStr.substring(binaryStr.length() - shift) + binaryStr.substring(0, binaryStr.length() - shift);
        return Integer.parseInt(shifted, 2);
    }

    // ---------------------------------------
    private static final int[][] MOVES = {
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    public static boolean knightBoardCapture(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : MOVES) {
                        int x = i + move[0];
                        int y = j + move[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Task 0
        LOGGER.info("Привет, мир!");

        // Task 1 - Длина видео
        var minutes = "10:45";
        System.out.println(minutesToSeconds(minutes));

        //Task 2 - Количество цифр
        long number = 123456;
        System.out.println(countDigits(number));

        // Task 3 - Вложенный массив
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{0, 6};
        System.out.println(isNestable(arr1, arr2));

        // Task 4 - Сломанная строка
        String str = "123456";
        System.out.println(fixString(str));

        // Task 5 - Особый палиндром
        System.out.println(isPalindromeDescendant(11211230));
        //System.out.println(isPalindromeDescendant(13001120));
        //System.out.println(isPalindromeDescendant(23336014));
        //System.out.println(isPalindromeDescendant(11));

        // Task 6 -  Постоянная Капрекара
        System.out.println(countK(6621));

        // Task 7 - Циклический битовый сдвиг
        System.out.println(rotateRight(8, 1));
        System.out.println(rotateLeft(16, 1));
        System.out.println(rotateLeft(17, 2));

        // Task 8
        int[][] array1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] array2 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        int[][] array3 = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(knightBoardCapture(array3));
    }
}
