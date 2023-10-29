package edu.hw3;

// it's a Task6

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Stock implements StockMarket {
    static List<Stock> stocks = new ArrayList<>();


    private Stock() {

    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);

    }

    @Override
    public Stock mostValuableStock() {
        PriorityQueue<Stock> queue = new PriorityQueue<>();
        queue.addAll(stocks);
        return queue.poll();
    }
}
