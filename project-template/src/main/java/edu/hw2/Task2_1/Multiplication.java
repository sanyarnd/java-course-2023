package edu.hw2.Task2_1;

public class Multiplication implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Multiplication(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public double evaluate() {
        return leftExpression.evaluate() * rightExpression.evaluate();
    }
}
