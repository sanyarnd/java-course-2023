package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("()()() -> (),(),()")
    void test1() {
        // given
        String string = "()()()";
        List<String> list = List.of("()", "()", "()");

        // when
        List<String> result = Task2.clusteringBrackets(string);

        // then
        assertEquals(result, list);
    }

    @Test
    @DisplayName("((())) -> ((()))")
    void test2() {
        // given
        String string = "((()))";
        List<String> list = List.of("((()))");

        // when
        List<String> result = Task2.clusteringBrackets(string);

        // then
        assertEquals(result, list);
    }

    @Test
    @DisplayName("((()))(())()()(()()) -> ((())),(()),(),(),(()())")
    void test3() {
        // given
        String string = "((()))(())()()(()())";
        List<String> list = List.of("((()))", "(())", "()", "()","(()())");

        // when
        List<String> result = Task2.clusteringBrackets(string);

        // then
        assertEquals(result, list);
    }

    @Test
    @DisplayName("((())())(()(()())) -> ((())()),(()(()()))")
    void test4() {
        // given
        String string = "((())())(()(()()))";
        List<String> list = List.of("((())())", "(()(()()))");

        // when
        List<String> result = Task2.clusteringBrackets(string);

        // then
        assertEquals(result, list);
    }

    @Test
    @DisplayName("null text -> null text")
    void test5() {
        // given
        String string = "";
        List<String> list = new ArrayList<>();

        // when
        List<String> result = Task2.clusteringBrackets(string);

        // then
        assertEquals(result, list);
    }
}
