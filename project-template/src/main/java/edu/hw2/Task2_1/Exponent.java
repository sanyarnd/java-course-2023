package edu.hw2.Task2_1;


public class Exponent implements Expression {
    private final Expression baseExpression;
    private final Expression powerExpression;

    public Exponent(Expression baseExpression, Expression powerExpression) {
        this.baseExpression = baseExpression;
        this.powerExpression = powerExpression;
    }

    @Override
    public double evaluate() {
        return Math.pow(baseExpression.evaluate(), powerExpression.evaluate());
    }
}
