package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    @DisplayName("Test1, input 01:00 output 60")
    void test1(){
        var seconds = task1.minutesToSeconds("01:00");
        assertThat(seconds).isEqualTo(60);
    }
    @Test
    @DisplayName("Test2, input 13:56 output 836")
    void test2(){
        var seconds = task1.minutesToSeconds("13:56");
        assertThat(seconds).isEqualTo(836);
    }
    @Test
    @DisplayName("Test3, input 10:60 output -1")
    void test3(){
        var seconds = task1.minutesToSeconds("10:60");
        assertThat(seconds).isEqualTo(-1);
    }
    @Test
    @DisplayName("Test4, input 999:59 output 59999")
    void test4(){
        var seconds = task1.minutesToSeconds("999:59");
        assertThat(seconds).isEqualTo(59999);
    }
}
