package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1VideoLengthTest {
    @Test
    @DisplayName("Секунд = 60")
    void test1() {
        // given
        String time = "00:60";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Количество секунд > 60")
    void test2() {
        // given
        String time = "00:70";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Пустая строка")
    void test3() {
        // given
        String time = "";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Без минут")
    void test4() {
        // given
        String time = ":45";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Без секунд")
    void test5() {
        // given
        String time = "60:";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Только разделитель")
    void test6() {
        // given
        String time = ":";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Без минут")
    void test7() {
        // given
        String time = ":45";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Неправильный разделитель")
    void test8() {
        // given
        String time = "2;45";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Три числа через двоеточие")
    void test9() {
        // given
        String time = "2:45:6";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Пробелы справа и слева от двоеточия")
    void test10() {
        // given
        String time = "2 : 45";
        // whe
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Пробелы рядом с кавычками")
    void test11() {
        // given
        String time = " 2:45 ";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(-1);
    }
    @Test
    @DisplayName("Несколько нулей в минутах")
    void test12() {
        // given
        String time = "2:45";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(2*60 + 45);
    }
    @Test
    @DisplayName("Несколько нулей в секундах")
    void test13() {
        // given
        String time = "2:0045";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(2*60 + 45);
    }
    @Test
    @DisplayName("Несколько нулей в минутах и секундах")
    void test14() {
        // given
        String time = "002:00045";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(2*60 + 45);
    }
    @Test
    @DisplayName("Корректные значения")
    void test15() {
        // given
        String time = "999:45";
        // when
        int wrong = Task1VideoLength.getSeconds(time);
        // then
        assertThat(wrong).isEqualTo(999*60 + 45);
    }
    @Test
    @DisplayName("Отрицательное время")
    void test16() {
        String time = "999:-45";
        int wrong = Task1VideoLength.getSeconds(time);
        assertThat(wrong).isEqualTo(-1);

        time = "-999:45";
        wrong = Task1VideoLength.getSeconds(time);
        assertThat(wrong).isEqualTo(-1);

        time = "-999:-45";
        wrong = Task1VideoLength.getSeconds(time);
        assertThat(wrong).isEqualTo(-1);
    }
}
