package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6KaprekarTest {
    @Test
    @DisplayName("Отрицательное четверозначное")
    void test1() {
        // given
        int value = -1234;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(-1);
    }
    @Test
    @DisplayName("Больше 9999")
    void test2() {
        // given
        int value = 12345;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(-1);
    }
    @Test
    @DisplayName("Одинаковые цифры")
    void test3() {
        // given
        int value = 7777;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(-1);
    }
    @Test
    @DisplayName("1 Тест с курса")
    void test4() {
        // given
        int value = 6621;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(5);
    }
    @Test
    @DisplayName("2 Тест с курса")
    void test5() {
        // given
        int value = 6554;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(4);
    }
    @Test
    @DisplayName("3 Тест с курса")
    void test6() {
        // given
        int value = 1234;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(3);
    }
    @Test
    @DisplayName("2 нуля в середине")
    void test7() {
        // given
        int value = 6001;
        // when
        int test = Task6Kaprekar.getKaprekarSteps(value);
        // then
        assertThat(test).isEqualTo(7);
    }
}
