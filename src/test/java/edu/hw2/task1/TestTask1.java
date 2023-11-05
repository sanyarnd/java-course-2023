package edu.hw2.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {
    @DisplayName("тестим Constant")
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "6, 6",
        "-10, -10",
        "0, 0",
        "10000000, 10000000"
    })
    public void TestConstant(int value, double ans){
        assertEquals(new Constant(value).evaluate(), ans);
    }
    @DisplayName("тестим Negate")
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "6, -6",
        "-10, 10",
        "0, 0",
        "10000000, -10000000"
    })
    public void TestNegate(int value, double ans){
        assertEquals(new Negate(new Constant(value)).evaluate(), ans);
    }
    @DisplayName("тестим Addition")
    @ParameterizedTest(name = "{index}: {0} + {1} = {2}")
    @CsvSource({
        "6, 5, 11",
        "-20, 5, -15",
        "-10, 10, 0",
        "11, 19, 30"
    })
    public void TestAddition(int value1, int value2, double ans){
        assertEquals(new Addition(new Constant(value1), new Constant(value2)).evaluate(), ans);
    }
    @DisplayName("тестим Multiplication")
    @ParameterizedTest(name = "{index}: {0} * {1} = {2}")
    @CsvSource({
        "6, 5, 30",
        "-20, 5, -100",
        "-10, 0, 0",
        "-10, -3, 30"
    })
    public void TestMultiplication(int value1, int value2, double ans){
        assertEquals(new Multiplication(new Constant(value1), new Constant(value2)).evaluate(), ans);
    }
    @DisplayName("тестим Exponent")
    @ParameterizedTest(name = "{index}: {0}^{1} = {2}")
    @CsvSource({
        "6, 2, 36",
        "-10, 2, 100",
        "2, 10, 1024",
        "10000, 0, 1",
        "1, 1000, 1"
    })
    public void TestExponent(int value, int power, double ans){
        assertEquals(new Exponent(new Constant(value), power).evaluate(), ans);
    }
}
