package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    @DisplayName("Test1, input 123456 output 214365")
    void test1(){
        var newStr = task4.fixString("123456");
        assertThat(newStr).isEqualTo("214365");
    }
    @Test
    @DisplayName("Test2, input hTsii  s aimex dpus rtni.g output This is a mixed up string.")
    void test2(){
        var newStr = task4.fixString("hTsii  s aimex dpus rtni.g");
        assertThat(newStr).isEqualTo("This is a mixed up string.");
    }
    @Test
    @DisplayName("Test3, input badce output abcde")
    void test3(){
        var newStr = task4.fixString("badce");
        assertThat(newStr).isEqualTo("abcde");
    }
    @Test
    @DisplayName("Test4, input abacaba output bacabaa")
    void test4(){
        var newStr = task4.fixString("abacaba");
        assertThat(newStr).isEqualTo("bacabaa");
    }
}
