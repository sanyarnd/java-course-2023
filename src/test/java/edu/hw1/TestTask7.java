package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask7 {
    @Test
    @DisplayName("Test1, input right (8, 1) output 4")
    void test1(){
        int newNum = Task7.rotateRight(8, 1);
        assertThat(newNum).isEqualTo(4);
    }
    @Test
    @DisplayName("Test2, input left (16, 1) output 1")
    void test2(){
        int newNum = Task7.rotateLeft(16, 1);
        assertThat(newNum).isEqualTo(1);
    }
    @Test
    @DisplayName("Test3, input left (17, 2) output 6")
    void test3(){
        int newNum = Task7.rotateLeft(17, 2);
        assertThat(newNum).isEqualTo(6);
    }
    @Test
    @DisplayName("Test4, input right (128, 10) output 32")
    void test4(){
        int newNum = Task7.rotateRight(128, 10);
        assertThat(newNum).isEqualTo(32);
    }
}
