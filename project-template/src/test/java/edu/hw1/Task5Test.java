package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    void standart() {
        assertEquals(true, Task5.isPalindromeDescendant(11211230));
        assertEquals(true, Task5.isPalindromeDescendant(13001120));
        assertEquals(true, Task5.isPalindromeDescendant(23336014));
        assertEquals(true, Task5.isPalindromeDescendant(11));
    }

    @Test
    void odd_length_of_num() {
        assertEquals(true, Task5.isPalindromeDescendant(121));
        assertEquals(false, Task5.isPalindromeDescendant(123));
    }

    @Test
    void sum_of_two_numbers_more_10() {

        assertEquals(true, Task5.isPalindromeDescendant(5683));
        assertEquals(true, Task5.isPalindromeDescendant(5582));//1010 -> 11
    }

}
