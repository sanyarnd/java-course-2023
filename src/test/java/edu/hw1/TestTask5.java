package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {
    @Test
    @DisplayName("Test1, input 11211230 output true")
    void test1(){
        var isPalindrome = task5.isPalindromeDescendant(11211230);
        assertThat(isPalindrome).isEqualTo(true);
    }
    @Test
    @DisplayName("Test2, input 13001120 output true")
    void test2(){
        var isPalindrome = task5.isPalindromeDescendant(13001120);
        assertThat(isPalindrome).isEqualTo(true);
    }
    @Test
    @DisplayName("Test3, input 23336014 output true")
    void test3(){
        var isPalindrome = task5.isPalindromeDescendant(23336014);
        assertThat(isPalindrome).isEqualTo(true);
    }
    @Test
    @DisplayName("Test4, input 425765276 output false")
    void test4(){
        var isPalindrome = task5.isPalindromeDescendant(425765276);
        assertThat(isPalindrome).isEqualTo(false);
    }
}
