package org.example;

import java.util.List;

/**
 * Класс, отвечающий за историю просмотров каких-либо элементов типа T
 * @param <T>
 */
public interface HistoryViewManager<T> {

    void addView(T uuid);

    List<T> getViewHistory();

}
