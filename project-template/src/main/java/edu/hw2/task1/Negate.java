package edu.hw2.task1;

public record Negate(Expr a) implements Expr {
    @Override
    public double evaluate() {
        return -a.evaluate() + 0;
    }
}
