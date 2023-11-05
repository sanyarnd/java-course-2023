package edu.hw3.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    @DisplayName("Тестим функцию atbash")
    void testsFromAtbash(){
        assertThat(Atbash.atbash("Hello world!")).isEqualTo("Svool dliow!");
        assertThat(Atbash.atbash("Any fool can write code that a computer can understand. " +
            "Good programmers write code that humans can understand. ― Martin Fowler"))
            .isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
                "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
        assertThat(Atbash.atbash("Salam  !!!  pam")).isEqualTo("Hzozn  !!!  kzn");
        assertThat(Atbash.atbash("abcdefgh")).isEqualTo("zyxwvuts");
    }
}
