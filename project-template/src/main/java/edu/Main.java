package edu;

import edu.hw1.Task1;
import edu.hw1.Task2;
import edu.hw1.Task3;
import edu.hw1.Task4;
import edu.hw1.Task5;
import edu.hw1.Task6;
import edu.hw1.Task7;
import edu.hw1.Task8;
import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Expr;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import edu.hw2.task4.CallingInfo;
import edu.hw3.task1.AtbashCipher;
import edu.hw3.task4.RomanNumerals;
import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import edu.hw3.task6.StockMarketImpl;
import edu.hw3.task8.ReverseIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static edu.hw2.task4.CallingInfo.callingInfo;
import static edu.hw3.task2.ClusteringBrackets.clusterize;
import static edu.hw3.task3.FrequencyOfWords.countOfWords;
import static edu.hw3.task5.ContactlList.parseContacts;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {}

    public static void Hw1(){
        Task1 task1 = new Task1();
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
        //Task2
        Task2 task2 = new Task2();
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
        //Task3
        Task3 task3 = new Task3();
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
        //Task4
        Task4 task4 = new Task4();
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
        //Task5
        Task5 task5 = new Task5();
        int num = 11211230;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 13001120;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 23336014;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 11;
        System.out.println(task5.isPalindromeDescendant(num));

        System.out.println();
        //Task6
        Task6 task6 = new Task6();
        int numForK = 6621;
        System.out.println(task6.countK(numForK));
        numForK = 6554;
        System.out.println(task6.countK(numForK));
        numForK = 1234;
        System.out.println(task6.countK(numForK));

        System.out.println();
        //Task7
        Task7 task7 = new Task7();
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
        //Task8
        Task8 task8 = new Task8();
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

    public static void Hw2(){
        //task1
        Expr two = new Constant(2);
        Expr four = new Constant(4);
        Expr negOne = new Negate(new Constant(1));
        Expr sumTwoFour = new Addition(two, four);
        Expr mult = new Multiplication(sumTwoFour, negOne);
        Expr exp = new Exponent(mult, 2);
        Expr res = new Addition(exp, new Constant(1));

        System.out.println(res + " = " + res.evaluate());

        System.out.println();
        //Task4
        CallingInfo info = callingInfo();
        System.out.println("Called from " + info.className() + "#" + info.methodName());
    }


    public static void main(String[] args) {
        //Hw1();
        //Hw2();

        //task1
        String encryptedText1 = AtbashCipher.encrypt("Hello, World!");
        System.out.println(encryptedText1);
        String encryptedText2 = AtbashCipher.encrypt("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
        System.out.println(encryptedText2);

        System.out.println();
        //task2
        String input1 = "()()()";
        List<String> clusters1 = clusterize(input1);
        System.out.println(clusters1);
        String input2 = "((()))";
        List<String> clusters2 = clusterize(input2);
        System.out.println(clusters2);
        String input3 = "((()))(())()()(()())";
        List<String> clusters3 = clusterize(input3);
        System.out.println(clusters3);
        String input4 = "((())())(()(()()))";
        List<String> clusters4 = clusterize(input4);
        System.out.println(clusters4);

        System.out.println();
        //task3
        List<String> words = List.of("a", "bb", "a", "bb");
        Map<String, Integer> freqMap1 = countOfWords(words);
        System.out.println(freqMap1);

        System.out.println();
        //task4
        RomanNumerals number = new RomanNumerals();
        String result = number.getRomanNumber(2);
        System.out.println(result);
        result = number.getRomanNumber(12);
        System.out.println(result);
        result = number.getRomanNumber(16);
        System.out.println(result);

        System.out.println();
        //task5
        String[] contacts1 = { "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" };
        String[] sortedContacts1 = parseContacts(contacts1, "ASC");
        System.out.println(Arrays.toString(sortedContacts1));

        String[] contacts2 = { "Paul Erdos", "Leonhard Euler", "Carl Gauss" };
        String[] sortedContacts2 = parseContacts(contacts2, "DESC");
        System.out.println(Arrays.toString(sortedContacts2));

        System.out.println();
        //task6
        StockMarket market = new StockMarketImpl();

        Stock stock1 = new Stock("Apple", 19650.50);
        Stock stock2 = new Stock("Google", 11200.75);
        Stock stock3 = new Stock("Mak", 20250.80);

        market.add(stock1);
        market.add(stock2);
        market.add(stock3);

        System.out.println(market.mostValuableStock().getSymbol());
        Stock delete = market.mostValuableStock();

        market.remove(delete);

        System.out.println(market.mostValuableStock().getSymbol());


        System.out.println();
        //task8
        List<Integer> numbers = List.of(1, 2, 3);
        ReverseIterator<Integer> iterator = new ReverseIterator<>(numbers);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
