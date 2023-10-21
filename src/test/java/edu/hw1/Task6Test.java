package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    void countKSuccess() {
        int number = 3524;

        int expected = 3;
        int result = Task6.countK(number);

        Assertions.assertEquals(expected, result);
    }
}
