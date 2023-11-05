package edu.hw3.task6;

public class Stock {
    private int cost;
    private String nameStock;

    private Stock() {
    }

    Stock(int cost) {
        this(null, cost);
    }

    Stock(String nameStock, int cost) {
        this.cost = cost;
        this.nameStock = nameStock;
    }
}
