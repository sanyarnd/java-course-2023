package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Является ли палиндромом число или его предки")
    public void testIsPalindromeDescendant() {
        assertThat(Task6.isPalindromeDescendant("11211230")).isTrue();
        assertThat(Task6.isPalindromeDescendant("13001120")).isTrue();
        assertThat(Task6.isPalindromeDescendant("23336014")).isTrue();
        assertThat(Task6.isPalindromeDescendant("11")).isTrue();
        assertThat(Task6.isPalindromeDescendant("123")).isTrue();
        assertThat(Task6.isPalindromeDescendant("1234")).isFalse();
    }

    @Test
    @DisplayName("Проверка функции палиндрома")
    public void testIsPalindrome() {
        assertThat(Task6.isPalindrome("123")).isFalse();
        assertThat(Task6.isPalindrome("12")).isFalse();
        assertThat(Task6.isPalindrome("123")).isFalse();
        assertThat(Task6.isPalindrome("121")).isTrue();
        assertThat(Task6.isPalindrome("1221")).isTrue();
        assertThat(Task6.isPalindrome("12321")).isTrue();
    }

    @Test
    @DisplayName("Проверка подсчёта предка числа")
    public void testSumAdjacentDigits() {
        assertThat(Task6.calculateDescendant("11211230")).isEqualTo("2333");
        assertThat(Task6.calculateDescendant("13001120")).isEqualTo("4022");
        assertThat(Task6.calculateDescendant("11")).isEqualTo("2");
        assertThat(Task6.calculateDescendant("123")).isEqualTo("33");
        assertThat(Task6.calculateDescendant("56")).isEqualTo("11");
    }
}
