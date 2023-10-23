package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    @DisplayName("Test1, input 0 output 1")
    void test1(){
        var cnt = task2.countDigits(0);
        assertThat(cnt).isEqualTo(1);
    }
    @Test
    @DisplayName("Test2, input 4666 output 4")
    void test2(){
        var cnt = task2.countDigits(4666);
        assertThat(cnt).isEqualTo(4);
    }
    @Test
    @DisplayName("Test3, input 544 output 3")
    void test3(){
        var cnt = task2.countDigits(544);
        assertThat(cnt).isEqualTo(3);
    }
    @Test
    @DisplayName("Test4, input 1092328 output 7")
    void test4(){
        var cnt = task2.countDigits(1092328);
        assertThat(cnt).isEqualTo(7);
    }
}
