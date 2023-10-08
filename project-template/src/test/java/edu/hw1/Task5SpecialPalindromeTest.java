package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5SpecialPalindromeTest {
    @Test
    @DisplayName("Для 1 итерации")
    void test1() {
        // given
        int value = 12321;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }
    @Test
    @DisplayName("1 Тест с курса")
    void test2() {
        // given
        int value = 11211230;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }
    @Test
    @DisplayName("C двумя нулями")
    void test3() {
        // given
        int value = 13001102;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }
    @Test
    @DisplayName("3 Тест с курса")
    void test4() {
        // given
        int value = 23336014;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }
    @Test
    @DisplayName("44")
    void test5() {
        // given
        int value = 44;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }
    @Test
    @DisplayName("1 цифра")
    void test6() {
        // given
        int value = 8;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(false);
    }

    @Test
    @DisplayName("Неправильный ответ")
    void test7() {
        // given
        int value = 2447;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(false);
    }
    @Test
    @DisplayName("Работает меньше 1 секунды")
    @Timeout(1)
    void test8() {
        // given
        int value = 11211230 ;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }
    @Test
    @DisplayName("Сумма чисел больше 10")
    void test9() {
        // given
        int value = 77000095 ;
        // when
        boolean test = Task5SpecialPalindrome.isSpecialPalindrome(value);
        // then
        assertThat(test).isEqualTo(true);
    }

}
