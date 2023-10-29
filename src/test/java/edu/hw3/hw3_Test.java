package edu.hw3;

import edu.hw3.task1.Person;
import edu.hw3.task1.Something;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class hw3_Test {
    @Test
    @DisplayName("Перевод строк")
    void atbash() {
        // given
        String str = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        // when
        String ans = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        String res = Something.atbash(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
    @Test
    @DisplayName("Кластеризация 1")
    void cluster1() throws Exception {
        // given
        String str = "((())())(()(()()))";
        // when
        ArrayList<String> ans = new ArrayList<>();
        ans.add("((())())");
        ans.add("(()(()()))");
        ArrayList<String> res = Something.clusterize(str);
        // then
        assertThat(res).isEqualTo(ans);
    }
}
