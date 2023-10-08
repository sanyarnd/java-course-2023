package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @ParameterizedTest
    @MethodSource("palindromeDescendantProvider")
    @DisplayName("Является ли палиндромом число или его предки")
    public void testIsPalindromeDescendant(String input, boolean expected) {
        assertThat(Task6.isPalindromeDescendant(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> palindromeDescendantProvider() {
        return Stream.of(
            Arguments.of("11211230", true),
            Arguments.of("13001120", true),
            Arguments.of("23336014", true),
            Arguments.of("11", true),
            Arguments.of("123", true),
            Arguments.of("1234", false)
        );
    }

    @ParameterizedTest
    @MethodSource("palindromeProvider")
    @DisplayName("Проверка функции палиндрома")
    public void testIsPalindrome(String input, boolean expected) {
        assertThat(Task6.isPalindrome(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> palindromeProvider() {
        return Stream.of(
            Arguments.of("123", false),
            Arguments.of("12", false),
            Arguments.of("123", false),
            Arguments.of("121", true),
            Arguments.of("1221", true),
            Arguments.of("12321", true)
        );
    }

    @ParameterizedTest
    @MethodSource("descendantProvider")
    @DisplayName("Проверка подсчёта предка числа")
    public void testSumAdjacentDigits(String input, String expected) {
        assertThat(Task6.calculateDescendant(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> descendantProvider() {
        return Stream.of(
            Arguments.of("11211230", "2333"),
            Arguments.of("13001120", "4022"),
            Arguments.of("11", "2"),
            Arguments.of("123", "33"),
            Arguments.of("56", "11")
        );
    }
}
