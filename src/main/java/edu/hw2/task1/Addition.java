package edu.hw2.task1;

public record Addition(Expr left, Expr right) implements Expr {
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
