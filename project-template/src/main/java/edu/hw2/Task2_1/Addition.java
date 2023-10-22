package edu.hw2.Task2_1;


public class Addition implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Addition(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public double evaluate() {
        return leftExpression.evaluate() + rightExpression.evaluate();
    }
}
