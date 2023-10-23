package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {
    @Test
    @DisplayName("Test1, input 3524 output 3")
    void test1(){
        int cnt = Task6.countK(3524);
        assertThat(cnt).isEqualTo(3);
    }
    @Test
    @DisplayName("Test2, input 6621 output 5")
    void test2(){
        int cnt = Task6.countK(6621);
        assertThat(cnt).isEqualTo(5);
    }
    @Test
    @DisplayName("Test3, input 6554 output 4")
    void test3(){
        int cnt = Task6.countK(6554);
        assertThat(cnt).isEqualTo(4);
    }
    @Test
    @DisplayName("Test4, input 1234 output 3")
    void test4(){
        int cnt = Task6.countK(1234);
        assertThat(cnt).isEqualTo(3);
    }
    @Test
    @DisplayName("Test5, input 6174 output 0")
    void test5(){
        int cnt = Task6.countK(6174);
        assertThat(cnt).isEqualTo(0);
    }
}
