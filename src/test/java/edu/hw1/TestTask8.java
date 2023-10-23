package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask8 {
    int[][] pos1 = new int[][]{
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 1, 0, 0, 0}
    },
    pos2 = new int[][]{
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0, 1, 0, 1}
    },
    pos3 = new int[][]{
        {0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0}
    };
    @Test
    @DisplayName("Test1, input pos1 output true")
    void test1(){
        boolean isGood = Task8.knightBoardCapture(pos1);
        assertThat(isGood).isEqualTo(true);
    }
    @Test
    @DisplayName("Test2, input pos2 output false")
    void test2(){
        boolean isGood = Task8.knightBoardCapture(pos2);
        assertThat(isGood).isEqualTo(false);
    }
    @Test
    @DisplayName("Test3, input pos3 output false")
    void test3(){
        boolean isGood = Task8.knightBoardCapture(pos3);
        assertThat(isGood).isEqualTo(false);
    }
}
