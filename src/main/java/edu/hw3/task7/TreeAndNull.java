package edu.hw3.task7;

import java.util.Comparator;

public class TreeAndNull<T> implements Comparator<T> {
    private Comparator<T> comparator;

    @Override
    public int compare(T obj1, T obj2) {
        if (obj1 == null && obj2 == null) {
            return 0;
        } else if (obj1 == null) {
            return -1;
        } else if (obj2 == null) {
            return 1;
        } else {
            return comparator.compare(obj1, obj2);
        }
    }
}
