package edu.hw2.task1;

public record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }
}
