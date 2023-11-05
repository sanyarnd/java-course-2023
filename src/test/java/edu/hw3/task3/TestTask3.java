package edu.hw3.task3;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.ArrayList;
import java.util.Arrays;

public class TestTask3 {
    @Test
    @DisplayName("Тест 1")
    public void test1(){
        ArrayList<String> forTest1 = new ArrayList<>(Arrays.asList("a", "bb", "a", "bb"));
        assertThat(FreqDict.freqDict(forTest1).toString()).isEqualTo("{bb: 2, a: 2}");
    }
    @Test
    @DisplayName("Тест 2")
    public void test2(){
        ArrayList<String> forTest1 = new ArrayList<>(Arrays.asList("this", "and", "that", "and"));
        assertThat(FreqDict.freqDict(forTest1).toString()).isEqualTo("{that: 1, and: 2, this: 1}");
    }
    @Test
    @DisplayName("Тест 3")
    public void test3(){
        ArrayList<String> forTest1 = new ArrayList<>(Arrays.asList("код", "код", "код", "bug"));
        assertThat(FreqDict.freqDict(forTest1).toString()).isEqualTo("{код: 3, bug: 1}");
    }
    @Test
    @DisplayName("Тест 4")
    public void test4(){
        ArrayList<Integer> forTest1 = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        assertThat(FreqDict.freqDict(forTest1).toString()).isEqualTo("{1: 2, 2: 2}");
    }
}
