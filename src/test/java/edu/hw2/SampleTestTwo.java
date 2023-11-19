package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Expr;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import edu.hw2.task3.Connection;
import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.StableConnection;
import edu.hw2.task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw2.task4.CallingInfo.callingInfo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SampleTestTwo {
    @ParameterizedTest
    @MethodSource("data_for_expressionCalculator")
    @DisplayName("Калькулятор выражений")
    void expressionCalculator_validInputNumbers_successTest(int fistConst, int secondConst, int thirdConst, int degree, int fouthConst, int res) {
        Expr two = new Constant(fistConst);
        Expr four = new Constant(secondConst);
        Expr negOne = new Negate(new Constant(thirdConst));
        Expr sumTwoFour = new Addition(two, four);
        Expr mult = new Multiplication(sumTwoFour, negOne);
        Expr exp = new Exponent(mult, degree);

        Expr result = new Addition(exp, new Constant(fouthConst));

        assertThat(result.evaluate()).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_expressionCalculator() {
        return Stream.of(
            Arguments.of(3, 3, 4, 2, 1, 577),
            Arguments.of(8, 9, 5, 2, 1, 7226)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_rect")
    @DisplayName("Площадь прямоугольника")
    void rectangleArea_validInputNumbers_successTest(int height, int width, double res) {
        Rectangle rect = new Rectangle(height, width);

        double result = rect.area();

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_rect() {
        return Stream.of(
            Arguments.of(50, 90, 4500),
            Arguments.of(30, 80, 2400)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_square")
    @DisplayName("Площадь квадрата")
    void squareArea_validInputNumbers_successTest(int height, double res) {
        Rectangle rect = new Square(height);

        double result = rect.area();

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_square() {
        return Stream.of(
            Arguments.of(20, 400),
            Arguments.of(30, 900)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_DefaultConnection")
    @DisplayName("Удаленный сервер - Default")
    void DefaultConnection_validInputString_successTest(double frequency, String command) throws Exception {
        ConnectionManager manager = new DefaultConnectionManager(frequency);
        Connection connection = manager.getConnection();
        connection.execute(command);
        try {
            connection.close();
        } catch (Exception e) {
            throw new ConnectionException(new RuntimeException("Connection error"));
        }
    }
    private static Stream<Arguments> data_for_DefaultConnection() {
        return Stream.of(
            Arguments.of(105.25, "gogo"),
            Arguments.of(150.25, "ls")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_FaultyConnection")
    @DisplayName("Удаленный сервер - Faulty")
    void FaultyConnection_validInputString_successTest(double frequency, String command) throws Exception {
        ConnectionManager manager = new FaultyConnectionManager(frequency);
        Connection connection = manager.getConnection();
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalStateException.class, () -> connection.execute(command));
    }
    private static Stream<Arguments> data_for_FaultyConnection() {
        return Stream.of(
            Arguments.of(105.25, "gogo"),
            Arguments.of(150.25, "ls")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_PopularCommand")
    @DisplayName("Удаленный сервер - Popular Command")
    void PopularCommand_validInputString_successTest(double frequency, int attempts) throws Exception {
        ConnectionManager manager = new DefaultConnectionManager(frequency);
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, attempts);
        executor.updatePackages();
    }
    private static Stream<Arguments> data_for_PopularCommand() {
        return Stream.of(
            Arguments.of(105.25, 3),
            Arguments.of(150.25, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_callingInfo")
    @DisplayName("Кто вызвал функцию?")
    void callingInfo_validInputString_successTest(String className, String methodName) {
        CallingInfo info = callingInfo();

        assertThat(className).isEqualTo(callingInfo().className());
        assertThat(methodName).isEqualTo(callingInfo().methodName());
    }
    private static Stream<Arguments> data_for_callingInfo() {
        return Stream.of(
            Arguments.of("edu.hw2.SampleTestTwo", "callingInfo_validInputString_successTest")
        );
    }
}
