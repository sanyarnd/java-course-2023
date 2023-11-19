package edu.hw3.task6;

import java.util.PriorityQueue;

public class StockMarketImpl implements StockMarket  {
    private PriorityQueue<Stock> stockQueue;

    public StockMarketImpl() {
        stockQueue = new PriorityQueue<>((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
    }

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }
}
