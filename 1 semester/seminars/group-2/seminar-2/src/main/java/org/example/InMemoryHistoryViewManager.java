package org.example;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class InMemoryHistoryViewManager<T> implements HistoryViewManager<T> {

    private final LinkedHashSet<T> history = new LinkedHashSet<>();

    @Override
    public void addView(T uuid) {
        history.remove(uuid);
        history.add(uuid);
    }

    @Override
    public List<T> getViewHistory() {
        return new ArrayList<>(history);
    }
}
