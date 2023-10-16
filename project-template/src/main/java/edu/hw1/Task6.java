package edu.hw1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task6 {
    static final int TARGET_NUMBER = 6174;

    private Task6() {
    }

//    public static void main(String[] args) {}

    public static int kaprekarSteps(int number) {
        if (number > 1000 && number < 10000 && !checkIfAllDigSame(number)) {
            return kaprekarStepsRec(number, 0);
        }

        return -1;
    }

    public static boolean checkIfAllDigSame(int number) {
        int lastDigit = number % 10;

        while (number > 0) {
            int digit = number % 10;
            if (digit != lastDigit) {
                return false;
            }
            number /= 10;
        }

        return true;
    }

    public static int kaprekarStepsRec(int number, int step) {
        if (number == TARGET_NUMBER) {
            return step;
        }

        int smallNum = sortNumber(number, true);
        int bigNum = sortNumber(number, false);
        return kaprekarStepsRec(bigNum - smallNum, ++step);
    }

    public static int sortNumber(int number, boolean isIncrOrder) {
        String numberStr = String.valueOf(number);

        String sortedNumberStr = Stream.of(numberStr.split(""))
            .map(Integer::parseInt)
            .sorted()
            .map(Object::toString)
            .collect(Collectors.joining());

        if (!isIncrOrder) {
            sortedNumberStr = new StringBuilder(sortedNumberStr).reverse().toString();
            if (sortedNumberStr.length() < 4){
                sortedNumberStr += '0';
            }
        }

        return Integer.parseInt(sortedNumberStr);
    }
}
