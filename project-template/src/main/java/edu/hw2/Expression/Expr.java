package edu.hw2.Expression;

public sealed interface Expr {
    double evaluate();

    public record Constant(double expr) implements Expr {
        public Constant(Expr e){
            this(e.evaluate());
        }
        @Override
        public double evaluate() {
            return expr;
        }
    }
    public record Negate(Expr expr) implements Expr {
        public Negate(double val){
            this(new Constant(val));
        }
        @Override
        public double evaluate(){
            return  - expr.evaluate();
        }
    }
    public record Exponent(Expr base, Expr power) implements Expr {
        public Exponent(Expr base, double power){
            this(base, new Constant(power));
        }
        public Exponent(double base, Expr power){
            this(new Constant(base), power);
        }
        public Exponent(double base, double power){
            this(new Constant(base), new Constant(power));
        }


        @Override
        public double evaluate(){
            return Math.pow(base.evaluate(), power.evaluate());
        }
    }
    public record Addition(Expr op1, Expr op2) implements Expr {
        public Addition(Expr base, double power){
            this(base, new Constant(power));
        }
        public Addition(double base, Expr power){
            this(new Constant(base), power);
        }
        public Addition(double base, double power){
            this(new Constant(base), new Constant(power));
        }
        @Override
        public double evaluate(){
            return op1.evaluate() + op2.evaluate();
        }
    }
    public record Multiplication(Expr op1, Expr op2) implements Expr {
        public Multiplication(Expr base, double power){
            this(base, new Constant(power));
        }
        public Multiplication(double base, Expr power){
            this(new Constant(base), power);
        }
        public Multiplication(double base, double power){
            this(new Constant(base), new Constant(power));
        }
        @Override
        public double evaluate(){
            return op1.evaluate() * op2.evaluate();
        }

    }
}
