package edu.hw1;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class EvenArrayUtils {
    private final static Logger LOGGER = LogManager.getLogger();

    private EvenArrayUtils() {
    }

    /**
     * Filters an array of integers, returning only the even numbers.
     *
     * @param numbers the array of integers to filter
     * @return an array of even integers from the original array
     * @throws NullPointerException if the input array is null
     */
    public static int[] filter(int[] numbers) {
        Objects.requireNonNull(numbers);
        LOGGER.trace("Filtering an array {}", numbers);

        int count = count(numbers);

        int[] result = new int[count];
        int idx = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                result[idx++] = number;
            }
        }
        return result;
    }

    /**
     * Counts the number of even integers in an array of integers.
     *
     * @param numbers the array of integers to count
     * @return the number of even integers in the array
     * @throws NullPointerException if the input array is null
     */
    public static int count(int[] numbers) {
        Objects.requireNonNull(numbers);

        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                ++count;
            }
        }
        return count;
    }
}
