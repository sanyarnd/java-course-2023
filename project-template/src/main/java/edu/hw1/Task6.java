package edu.hw1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task6 {
    final static int TARGET_NUMBER = 6174;
    final static int MAX_STEP_COUNT = 7;

    private Task6() {
    }

    public static void main(String[] args) {
    }

    public static int kaprekarSteps(int number) {
        if (number > 1000 && number < 10000) {
            return kaprekarStepsRec(number, 0);
        }

        return -1;
    }

    public static int kaprekarStepsRec(int number, int step) {
        if (number == TARGET_NUMBER) {
            return step;
        }

        if (step > MAX_STEP_COUNT) {
            return -1;
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

        sortedNumberStr = isIncrOrder ? sortedNumberStr : new StringBuilder(sortedNumberStr).reverse().toString();
        return Integer.parseInt(sortedNumberStr);
    }
}
