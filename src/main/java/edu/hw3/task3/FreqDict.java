package edu.hw3.task3;

import java.util.ArrayList;

public class FreqDict {
    private FreqDict() {
    }

    public static <T> MyHashMap<T, Integer> freqDict(ArrayList<T> arrayListStrings) {
        MyHashMap<T, Integer> hashMap = new MyHashMap<>();
        for (T nowElem : arrayListStrings) {
            hashMap.merge(nowElem, 1, Integer::sum);
        }
        return hashMap;
    }
}
