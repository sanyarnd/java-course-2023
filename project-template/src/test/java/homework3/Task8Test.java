package homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class Task8Test {
    @Test
    public void testBackwardIterator() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Task8<Integer> backwardIterator = new Task8<>(list);

        List<Integer> reversedList = new ArrayList<>();
        while (backwardIterator.hasNext()) {
            reversedList.add(backwardIterator.next());
        }

        assertEquals(Arrays.asList(5, 4, 3, 2, 1), reversedList);
    }

}
