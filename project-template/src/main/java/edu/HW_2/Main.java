package edu.HW_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));
        System.out.println(res + " = " + res.evaluate());

        CallingInfo info = callingInfo();
        System.out.println("Calling Class: " + info.className());
        System.out.println("Calling Method: " + info.methodName());
    }

    /**
     * 1.
     */
    public sealed interface Expr {
        double evaluate();

        public record Constant(double value) implements Expr {
            @Override public double evaluate() {
                return value;
            }
        }

        public record Negate(Expr operand) implements Expr {
            @Override public double evaluate() {
                return -operand.evaluate();
            }
        }

        public record Exponent(Expr base, Integer i) implements Expr {
            @Override public double evaluate() {
                return Math.pow(base.evaluate(), i);
            }
        }

        public record Addition(Expr left, Expr right) implements Expr {
            @Override public double evaluate() {
                return left.evaluate() + right.evaluate();
            }
        }

        public record Multiplication(Expr left, Expr right) implements Expr {
            @Override public double evaluate() {
                return left.evaluate() * right.evaluate();
            }
        }
    }

    /**
     * 2.
     */
    public static class Rectangle {
        private int width;
        private int height;

        public Rectangle(int width, int height) {
            setWidth(width);
            setHeight(height);
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public double area() {
            return width * height;
        }
    }

    public class Square {
        private final Rectangle rectangle;

        public Square(int sideLength) {
            rectangle = new Rectangle(sideLength, sideLength);
        }

        public void setSideLength(int sideLength) {
            rectangle.setWidth(sideLength);
            rectangle.setHeight(sideLength);
        }

        public int getSideLength() {
            return rectangle.getWidth();
        }

        public double area() {
            return rectangle.area();
        }
    }

    /**
     * 3.
     */
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public class ConnectionException extends RuntimeException {
    }

    public class StableConnection implements Connection {
        @Override public void execute(String command) {
            System.out.println("Executing command: " + command);
        }

        @Override public void close() {
            System.out.println("Closing stable connection");
        }
    }

    public class FaultyConnection implements Connection {
        private final double failureRate;
        private final Random random = new Random();

        public FaultyConnection(double failureRate) {
            this.failureRate = failureRate;
        }

        @Override public void execute(String command) {
            if (random.nextDouble() < failureRate) {
                throw new RuntimeException("Connection failed");
            }
            System.out.println("Executing command: " + command);
        }

        @Override public void close() {
            System.out.println("Closing faulty connection");
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public class DefaultConnectionManager implements ConnectionManager {
        private final double failureRate;

        public DefaultConnectionManager(double failureRate) {
            this.failureRate = failureRate;
        }

        @Override public Connection getConnection() {
            return new FaultyConnection(failureRate);
        }
    }

    public class FaultyConnectionManager implements ConnectionManager {
        @Override public Connection getConnection() {
            return new FaultyConnection(1.0); // ������ ���������� ����������
        }
    }

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void tryExecute(String command) {
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return; // ������� ��������� �������
                } catch (Exception e) {
                    if (attempt == maxAttempts) {
                        throw new RuntimeException("Failed to execute command after " + maxAttempts + " attempts", e);
                    }
                }
            }
        }
    }

    /**
     * 4.
     */
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // ������ 2 ������������� ������ callingInfo(), 3 - ����������� ������, � ��� �����
        if (stackTrace.length > 3) {
            StackTraceElement caller = stackTrace[3];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return new CallingInfo("Unknown", "Unknown");
        }
    }

    public record CallingInfo(String className, String methodName) {
    }
}
