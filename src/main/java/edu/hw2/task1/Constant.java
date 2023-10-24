package edu.hw2.task1;

public record Constant(double a) implements Expr {
    @Override
    public double evaluate() {
        return a;
    }
}
