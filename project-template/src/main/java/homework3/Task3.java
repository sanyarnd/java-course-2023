package homework3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static <T> Map<T, Integer> freqDict(List<T> inputList) {
        Map<T, Integer> frequencyMap = new HashMap<>();

        for (T item : inputList) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }
}
