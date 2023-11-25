package edu.hw7;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Task2 {
    public static BigInteger countFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n < 2) {
            return BigInteger.valueOf(1);
        }

        return IntStream.rangeClosed(2, n)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
