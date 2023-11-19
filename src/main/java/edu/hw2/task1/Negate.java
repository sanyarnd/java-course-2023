package edu.hw2.task1;

public record Negate(Expr expr) implements Expr {
    @Override
    public double evaluate() {
        return -expr.evaluate();
    }
}
