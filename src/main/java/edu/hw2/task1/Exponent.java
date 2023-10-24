package edu.hw2.task1;

public record Exponent(Expr a, int power) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(a.evaluate(), power);
    }
}
