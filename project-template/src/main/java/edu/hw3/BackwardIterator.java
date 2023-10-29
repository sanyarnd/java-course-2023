package edu.hw3;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> data;
    private int index;

    public BackwardIterator(List<T> data) {
        this.data = data;
        this.index = data.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        return data.get(index--);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

