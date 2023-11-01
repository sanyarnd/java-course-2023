package homework3;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    public void test1() {
        List<String> inputList = List.of("bb", "ba", "a", "bb");
        Map<String, Integer> result = Task3.freqDict(inputList);
        int res1 = result.get("a");
        int res2 = result.get("bb");
        assertEquals(2, res1);
        assertEquals(2, res2);
    }

    @Test
    public void test2() {
        List<Integer> inputList = List.of(1, 1, 2, 2);
        Map<Integer, Integer> result = Task3.freqDict(inputList);
        int res1 = result.get(1);
        int res2 = result.get(2);
        assertEquals(2, res1);
        assertEquals(2, res2);
    }

    @Test
    public void test3() {
        List<Object> inputList = List.of("ba", "aa", 1, "a", "bb", 2);
        Map<Object, Integer> result = Task3.freqDict(inputList);
        int res1 = result.get("a");
        int res2 = result.get("ba");
        int res3 = result.get(1);
        int res4 = result.get(2);
        assertEquals(1, res1);
        assertEquals(2, res2);
        assertEquals(1, res3);
        assertEquals(1, res4);
    }

    @Test
    public void test4() {
        List<Object> inputList = List.of();
        Map<Object, Integer> result = Task3.freqDict(inputList);
        assertEquals(0, result.size());
    }
}
