package edu.hw2;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Проверяем работоспособность интерфейса Expr")
public class Task1Test {

    @Test
    @DisplayName("Проверяем работоспособность метода evaluate")
    void testExpressionEvaluation() {
        Expr two = new Expr.Constant(2);
        Expr four = new Expr.Constant(4);
        Expr negOne = new Expr.Negate(new Expr.Constant(1));
        Expr sumTwoFour = new Expr.Addition(two, four);
        Expr mult = new Expr.Multiplication(sumTwoFour, negOne);
        Expr exp = new Expr.Exponent(mult, 2); // 36
        Expr res = new Expr.Addition(exp, new Expr.Constant(1)); // 37

        assertThat(res.evaluate()).isEqualTo(37); // Проверяем, что результат выражения равен 37
    }

    @Test
    @DisplayName("Проверяем корректность переопределения метода toString")
    void testExpressionStringRepresentation() {
        Expr two = new Expr.Constant(2);
        Expr four = new Expr.Constant(4);
        Expr negOne = new Expr.Negate(new Expr.Constant(1));
        Expr sumTwoFour = new Expr.Addition(two, four);
        Expr mult = new Expr.Multiplication(sumTwoFour, negOne);
        Expr exp = new Expr.Exponent(mult, 2); // 36
        Expr res = new Expr.Addition(exp, new Expr.Constant(1)); // 37

        assertThat(res.toString()).isEqualTo("((((2.0 + 4.0) * -(1.0))^2) + 1.0)"); // Проверяем строковое представление выражения
    }
}

