package homework3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task8<T> implements Iterator<T> {
    private final T[] elements;
    private int currentIndex;

    public Task8(Collection<T> collection) {
        this.elements = (T[]) collection.toArray();
        this.currentIndex = elements.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements[currentIndex--];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}
