package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    @DisplayName("a,bb,a,bb -> bb:2, a:2")
    void test1() {
        // given
        List<String> list = List.of("a", "bb", "a", "bb");
        Map<String, Integer> map = Map.of("a", 2, "bb", 2);

        // when
        Map<String, Integer> result = Task3.freqDict(list);

        // then
        assertEquals(result, map);
    }

    @Test
    @DisplayName("this,and,that,and -> that:1, and:2, this:1")
    void test2() {
        // given
        List<String> list = List.of("this", "and", "that", "and");
        Map<String, Integer> map = Map.of("that", 1, "and", 2, "this", 1);

        // when
        Map<String, Integer> result = Task3.freqDict(list);

        // then
        assertEquals(result, map);
    }

    @Test
    @DisplayName("код,код,код,bug -> код:3, bug:1")
    void test3() {
        // given
        List<String> list = List.of("код", "код", "код", "bug");
        Map<String, Integer> map = Map.of("код", 3, "bug", 1);

        // when
        Map<String, Integer> result = Task3.freqDict(list);

        // then
        assertEquals(result, map);
    }

    @Test
    @DisplayName("1,1,2,2 -> 1:2, 2:2")
    void test4() {
        // given
        List<Integer> list = List.of(1,1,2,2);
        Map<Integer, Integer> map = Map.of(1, 2, 2, 2);

        // when
        Map<Integer, Integer> result = Task3.freqDict(list);

        // then
        assertEquals(result, map);
    }

    @Test
    @DisplayName("null -> null")
    void test5() {
        // given
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // when
        Map<String, Integer> result = Task3.freqDict(list);

        // then
        assertEquals(result, map);
    }
}
