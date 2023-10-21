package edu.hw2.Task1;

public sealed interface Expr { // Task 1
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }

        @Override
        public String toString() {
            return Double.toString(value);
        }
    }

    record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }

        @Override
        public String toString() {
            return "-(" + expr + ")";
        }
    }

    record Exponent(Expr base, int power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }

        @Override
        public String toString() {
            return "(" + base + "^" + power + ")";
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        @Override
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }

        @Override
        public String toString() {
            return "(" + left + " + " + right + ")";
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        @Override
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }

        @Override
        public String toString() {
            return "(" + left + " * " + right + ")";
        }
    }
}
