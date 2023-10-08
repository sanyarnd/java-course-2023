package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2CountDigitsTest {
    @Test
    @DisplayName("Корректное значение")
    void test1() {
        // given
        int value = 123456;
        // when
        int test = Task2CountDigits.getCountDigits(value);
        // then
        assertThat(test).isEqualTo(6);
    }
    @Test
    @DisplayName("Ноль")
    void test() {
        // given
        int value = 0;
        // when
        int test = Task2CountDigits.getCountDigits(value);
        // then
        assertThat(test).isEqualTo(1);
    }
}
