package edu.hw2.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    @DisplayName("rectangleArea")
    void rectangleArea(){
        Rectangle a = new Rectangle(10, 20);
        assertThat(a.area()).isEqualTo(200);
        a = a.setWidth(20);
        assertThat(a.area()).isEqualTo(400);
        a = a.setHeight(4);
        assertThat(a.area()).isEqualTo(80);
    }

    @Test
    @DisplayName("squareArea")
    void squareArea(){
        Rectangle a = new Square(10);
        assertThat(a.area()).isEqualTo(100);
        a = a.setHeight(20);
        assertThat(a.area()).isEqualTo(400);
        a = a.setWidth(9);
        assertThat(a.area()).isEqualTo(81);
    }
}
