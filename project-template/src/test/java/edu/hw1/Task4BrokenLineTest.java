package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task4BrokenLineTest {
    @Test
    @DisplayName("Пустая строка")
    void test1() {
        // given
        String test = "";
        // when
        String answer = Task4BrokenLine.getFixedLine(test);
        // then
        assertThat(answer).isEqualTo("");
    }
    @Test
    @DisplayName("Один символ")
    void test2() {
        // given
        String test = "j";
        // when
        String answer = Task4BrokenLine.getFixedLine(test);
        // then
        assertThat(answer).isEqualTo("j");
    }
    @Test
    @DisplayName("Два символа")
    void test3() {
        // given
        String test = "io";
        // when
        String answer = Task4BrokenLine.getFixedLine(test);
        // then
        assertThat(answer).isEqualTo("oi");
    }
    @Test
    @DisplayName("Пример из курса")
    void test4() {
        // given
        String test = "hTsii  s aimex dpus rtni.g";
        // when
        String answer = Task4BrokenLine.getFixedLine(test);
        // then
        assertThat(answer).isEqualTo("This is a mixed up string.");
    }
}
