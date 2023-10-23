package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {
    @Test
    @DisplayName("Test1, input [1, 2, 3, 4], [0, 6] output true")
    void test1(){
        boolean isNest = Task3.isNestable(new int[] {1, 2, 3, 4}, new int[]{0, 6});
        assertThat(isNest).isEqualTo(true);
    }
    @Test
    @DisplayName("Test2, input [3, 1], [4, 0] output true")
    void test2(){
        boolean isNest = Task3.isNestable(new int[] {3, 1}, new int[]{4, 0});
        assertThat(isNest).isEqualTo(true);
    }
    @Test
    @DisplayName("Test3, input [9, 9, 8], [8, 9] output false")
    void test3(){
        boolean isNest = Task3.isNestable(new int[] {9, 9, 8}, new int[]{8, 9});
        assertThat(isNest).isEqualTo(false);
    }
    @Test
    @DisplayName("Test4, input [1, 2, 3, 4], [2, 3] output false")
    void test4(){
        boolean isNest = Task3.isNestable(new int[] {1, 2, 3, 4}, new int[]{2, 3});
        assertThat(isNest).isEqualTo(false);
    }
}
