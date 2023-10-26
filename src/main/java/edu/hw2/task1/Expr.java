package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double num) implements Expr {
        @Override
        public double evaluate() {
            return num;
        }
    }

    public record Negate(Expr constant) implements Expr {
        @Override
        public double evaluate() {
            return -this.constant.evaluate();
        }
    }

    public record Exponent(Expr const1, double const2) implements Expr {
        @Override
        public double evaluate() {
            double b = this.const1.evaluate();
            double res = 1;
            for (int i = 0; i < this.const2; i++) {
                res *= b;
            }
            return res;
        }
    }

    public record Addition(Expr const1, Expr const2) implements Expr {
        @Override
        public double evaluate() {
            return this.const1.evaluate() + this.const2.evaluate();
        }
    }

    public record Multiplication(Expr const1, Expr const2) implements Expr {
        @Override
        public double evaluate() {
            return this.const1.evaluate() * this.const2.evaluate();
        }
    }
}
