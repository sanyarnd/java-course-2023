package edu.hw2.Task2_1;

public class Negate implements Expression {
    private final Expression expression;

    public Negate(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return -expression.evaluate();
    }
}
