package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    @DisplayName("Hello world! -> Svool dliow!")
    void test1() {
        // given
        String string = "Hello world!";

        // when
        String result = String.valueOf(Task1.textEncryption(string));

        // then
        assertEquals(result, "Svool dliow!");
    }

    @Test
    @DisplayName("Any fool... -> Zmb ullo...")
    void test2() {
        // given
        String string = "Any fool can write code that a computer can understand. " +
            "Good programmers write code that humans can understand. ― Martin Fowler";

        // when
        String result = String.valueOf(Task1.textEncryption(string));

        // then
        assertEquals(result, "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
            "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("Null text -> Nothing")
    void test3() {
        // given
        String string = "";

        // when
        String result = String.valueOf(Task1.textEncryption(string));

        // then
        assertEquals(result, "");
    }


}
