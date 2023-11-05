package edu.hw3.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    @DisplayName("Тестим функцию clusterize")
    void testsFromClusterize(){
        assertThat(Clusterize.clusterize("()()()").toString()).isEqualTo("[(), (), ()]");
        assertThat(Clusterize.clusterize("((()))").toString()).isEqualTo("[((()))]");
        assertThat(Clusterize.clusterize("((()))(())()()(()())").toString()).isEqualTo("[((())), (()), (), (), (()())]");
        assertThat(Clusterize.clusterize("((())())(()(()()))").toString()).isEqualTo("[((())()), (()(()()))]");
        assertThat(Clusterize.clusterize("((())))").toString()).isEqualTo("[ERROR]");
    }
}
