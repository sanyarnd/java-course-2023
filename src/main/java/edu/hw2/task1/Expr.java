package edu.hw2.task1;

public sealed interface Expr permits Constant, Negate, Addition, Multiplication, Exponent {
    double evaluate();
}
