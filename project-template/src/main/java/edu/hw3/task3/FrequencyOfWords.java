package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfWords {
        public static <String> Map<String, Integer> countOfWords(List<String> input) {
            Map<String, Integer> freqMap = new HashMap<>();

            for (String item : input) {
                freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
            }

            return freqMap;
        }
}
