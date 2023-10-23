package edu.hw1;

import java.util.*;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        zeroTask();
        System.out.println(firstTask("13:56"));
        System.out.println(secondTask(1));

        int[] first = new int[] {1, 2, 3, 4};
        int[] second = new int[] {0, 6};
        System.out.println(thirdTask(first, second));

        System.out.println(fourthTask("hTsii  s aimex dpus rtni.g"));
        System.out.println(fifthTask(11211230));
        System.out.println(sixth(6621,0));
        System.out.println(seventhLeft(17,2));
        int[][] deck = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        System.out.println(eighth(deck));
    }

    /**
     * 0.
     */
    public static void zeroTask() {
        Logger logger = Logger.getLogger("Logger");
        logger.info("Hello, world!");
    }

    /**
     * 1.
     */
    public static int firstTask(String str) {
        String[] parts = str.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        if (sec >= 60) {
            return -1;
        }
        else
            return min * 60 + sec;
    }

    /**
     * 2.
     */
    public static int secondTask(int number) {
        if (number == 0)
            return 1;
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    /**
     * 3.
     */
    public static boolean thirdTask(int[] first, int[] second) {
        int minFirst = (int) Arrays.stream(first).min().orElse(0);
        int minSecond = (int) Arrays.stream(second).min().orElse(0);
        int maxFirst = (int) Arrays.stream(first).max().orElse(0);
        int maxSecond = (int) Arrays.stream(second).max().orElse(0);
        if (minSecond <= minFirst && maxSecond >= maxFirst)
            return true;
        else
            return false;

    }

    /**
     * 4.
     */
    public static String fourthTask(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i = i + 2) {
            char s = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = s;
        }
        return new String(charArray);
    }

    /**
     * 5.
     */
    public static boolean fifthTask(int number) {
        boolean res = false;
        while (!res || number > 0) {
            int oldNumber = number;
            int reverseNumber = 0;
            int rem = 0;
            while (number > 0) {
                rem = number % 10;
                reverseNumber = (reverseNumber * 10) + rem;
                number = number / 10;
            }
            if (oldNumber == reverseNumber)
                res = true;
            else {
                while (reverseNumber > 0) {
                    rem = reverseNumber % 100 / 10 + reverseNumber % 10;
                    number = (number * 10) + rem;
                    reverseNumber = reverseNumber / 100;
                }
            }
        }
        return res;
    }

    /**
     * 6.
     */
    public static int sixth(int number, int count) {
        if (number == 6174)
            return count;
        else {
            int[] array = new int[4];
            for (int i = 0; i < 4; i++) {
                array[i] = number % 10;
                number /= 10;
            }
            Arrays.sort(array);
            int order = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            Arrays.sort(array);
            int reorder = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            count++;
            return sixth(Math.abs(order - reorder), count);
        }
    }
    /**
     * 7.
     */
    public static String seventhLeft(int number, int shift) {
        char[] str = seventh(number).toCharArray();
        String old = new String(str);
        for (int j = 0; j < shift; j++) {
            char first = str[0];
            for (int i = 0; i < str.length - 1; i++) {
                str[i] = str[i + 1];
            }
            str[str.length - 1] = first;
        }
        String result = new String(str);
        return new String(number + ": " + old + " -> " + result);
    }

    public static String seventhRight(int number, int shift) {
        char[] str = seventh(number).toCharArray();
        String old = new String(str);
        for (int j = 0; j < shift; j++) {
            char lst = str[str.length - 1];
            for (int i = str.length - 1; i > 0; i--) {
                str[i] = str[i - 1];
            }
            str[0] = lst;
        }
        String result = new String(str);
        return new String(number + ": " + old + " -> " + result);
    }

    public static String seventh(int number) {
        StringBuilder str = new StringBuilder();
        char ch;
        String nstr = "";
        while (number != 1) {
            str.append(number % 2);
            number /= 2;
        }
        str.append(1);
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            nstr = ch + nstr;
        }
        return nstr;
    }
    /**
     * 8.
     */
    public static boolean eighth(int[][] deck) {
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (deck[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < 8 && y >= 0 && y < 8 && deck[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return  true;
    }
}
