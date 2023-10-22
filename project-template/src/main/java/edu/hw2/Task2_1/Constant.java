package edu.hw2.Task2_1;

public class Constant implements Expression {
    private final double constant;

    public Constant(double constant) {
        this.constant = constant;
    }

    @Override
    public double evaluate() {
        return constant;
    }
}
