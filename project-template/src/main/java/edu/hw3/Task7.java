package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class Task7 {
    static TreeMap<String, String> tree = new TreeMap<>(nullFirstComparator());


    private Task7() {

    }

    public static void add(String key, String text) {
        tree.put(key, text);
    }

    public static Comparator<String> nullFirstComparator() {
        return (s1, s2) -> {
            if (s1 == null && s2 == null) {
                return 0;
            }
            if (s1 == null) {
                return -1;
            }
            if (s2 == null) {
                return 1;
            }
            return s1.compareTo(s2);
        };
    }

}
