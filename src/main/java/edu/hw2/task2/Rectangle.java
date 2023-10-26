package edu.hw2.task2;

public class Rectangle {
    private int width;
    private int height;

    int setWidth(int width) {
        this.width = width;
        return this.width;
    }

    int setHeight(int height) {
        this.height = height;
        return this.height;
    }

    double area() {
        return width * height;
    }
}
