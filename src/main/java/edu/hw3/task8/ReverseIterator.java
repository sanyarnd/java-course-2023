package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReverseIterator<T> implements Iterator<T> {
    private ListIterator<T> iterator;

    public ReverseIterator(Collection<T> collection) {
        List<T> list = List.copyOf(collection);
        this.iterator = list.listIterator(list.size());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasPrevious();
    }

    @Override
    public T next() {
        return iterator.previous();
    }
}
