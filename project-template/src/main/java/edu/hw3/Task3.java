package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {

    }

    public static <T> Map<T, Integer> freqDict(List<T> words) {
        Map<T, Integer> mapOfWords = new HashMap<>();
        for (T word: words) {
            if (mapOfWords.containsKey(word)) {
                mapOfWords.replace(word, mapOfWords.get(word) + 1);
            } else {
                mapOfWords.put(word, 1);
            }
        }
        return mapOfWords;
    }
}
