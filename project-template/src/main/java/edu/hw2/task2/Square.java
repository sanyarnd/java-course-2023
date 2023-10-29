package edu.hw2.task2;

public class Square extends Rectangle {
    public Square(int a) {
        super(a, a);
    }

    @Override
    public Rectangle setWidth(int a) {
        return new Square(a);
    }

    @Override
    public Rectangle setHeight(int a) {
        return new Square(a);
    }
}
