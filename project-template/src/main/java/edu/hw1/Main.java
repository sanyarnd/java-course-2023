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

    public static void main(String[] args) {
        //task0
//        LOGGER.info("Hello and welcome!");
//        for (int i = 0; i <= 2; i++) {
//
//            LOGGER.info("i = {}", i);
//        }

        //task1
        task1 task1 = new task1();
        String length = "01:00";
        int totalSeconds = task1.minutesToSeconds(length);
        System.out.println(totalSeconds);
        length = "13:56";
        totalSeconds = task1.minutesToSeconds(length);
        System.out.println(totalSeconds);
        length = "10:60";
        totalSeconds = task1.minutesToSeconds(length);
        System.out.println(totalSeconds);

        System.out.println();
        //task2
        task2 task2 = new task2();
        int number = 4666;
        int totalDigits = task2.countDigits(number);
        System.out.println(totalDigits);
        number = 544;
        totalDigits = task2.countDigits(number);
        System.out.println(totalDigits);
        number = 0;
        totalDigits = task2.countDigits(number);
        System.out.println(totalDigits);

        System.out.println();
        //task3
        task3 task3 = new task3();
        int[] array1_1 = {1, 2, 3, 4};
        int[] array2_1 = {0, 6};
        System.out.println(task3.isNestable(array1_1, array2_1));
        int[] array1_2 = {3, 1};
        int[] array2_2 = {4, 0};
        System.out.println(task3.isNestable(array1_2, array2_2));
        int[] array1_3 = {9, 9, 8};
        int[] array2_3 = {8, 9};
        System.out.println(task3.isNestable(array1_3, array2_3));
        int[] array1_4 = {1, 2, 3, 4};
        int[] array2_4 = {2, 3};
        System.out.println(task3.isNestable(array1_4, array2_4));

        System.out.println();
        //task4
        task4 task4 = new task4();
        String str = "123456";
        char[] arr = str.toCharArray();
        System.out.println(task4.fixString(arr));
        str = "hTsii  s aimex dpus rtni.g";
        arr = str.toCharArray();
        System.out.println(task4.fixString(arr));
        str = "badce";
        arr = str.toCharArray();
        System.out.println(task4.fixString(arr));

        System.out.println();
        //task5
        task5 task5 = new task5();
        int num = 11211230;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 13001120;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 23336014;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 11;
        System.out.println(task5.isPalindromeDescendant(num));

        System.out.println();
        //task6
        task6 task6 = new task6();
        int numForK = 6621;
        System.out.println(task6.countK(numForK));
        numForK = 6554;
        System.out.println(task6.countK(numForK));
        numForK = 1234;
        System.out.println(task6.countK(numForK));

        System.out.println();
        //task7
        task7 task7 = new task7();
        int n = 8;
        int shift = 1;
        System.out.println(task7.rotateRight(n, shift));
        n = 16;
        shift = 1;
        System.out.println(task7.rotateLeft(n, shift));
        n = 17;
        shift = 2;
        System.out.println(task7.rotateLeft(n, shift));

        System.out.println();
        //task8
        task8 task8 = new task8();
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
        System.out.println(task8.knightBoardCapture(board));

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
        System.out.println(task8.knightBoardCapture(board1));

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
        System.out.println(task8.knightBoardCapture(board2));
    }
}
