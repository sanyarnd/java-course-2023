package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Shape;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;

public class Task2Test {

    @Test
    void testRectangleSetWidth() {
        Shape rectangle = new Rectangle();
        rectangle.setWidth(10);
        assertThat(rectangle.getWidth()).isEqualTo(10);
    }

    @Test
    void testRectangleSetHeight() {
        Shape rectangle = new Rectangle();
        rectangle.setHeight(20);
        assertThat(rectangle.getHeight()).isEqualTo(20);
    }


    @Test
    void testSquareSetWidth() {
        Shape square = new Square();
        square.setWidth(15);
        assertThat(square.getWidth()).isEqualTo(15);
        assertThat(square.getHeight()).isEqualTo(15);
    }

    @Test
    void testSquareSetHeight() {
        Shape square = new Square();
        square.setHeight(25);
        assertThat(square.getWidth()).isEqualTo(25);
        assertThat(square.getHeight()).isEqualTo(25);
    }

    @ParameterizedTest
    @MethodSource("rectangleParams")
    void testRectangleArea(int width, int height, double expectedArea) {
        Shape rectangle = new Rectangle();
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        assertThat(rectangle.area()).isEqualTo(expectedArea);
    }

    @ParameterizedTest
    @MethodSource("squareParams")
    void testSquareArea(int side, double expectedArea) {
        Shape square = new Square();
        square.setWidth(side);
        assertThat(square.area()).isEqualTo(expectedArea);
    }

    private static Stream<Arguments> rectangleParams() {
        return Stream.of(
            Arguments.of(10, 20, 200.0),
            Arguments.of(5, 10, 50.0),
            Arguments.of(15, 30, 450.0)
        );
    }

    private static Stream<Arguments> squareParams() {
        return Stream.of(
            Arguments.of(10, 100.0),
            Arguments.of(15, 225.0),
            Arguments.of(20, 400.0)
        );
    }
}
