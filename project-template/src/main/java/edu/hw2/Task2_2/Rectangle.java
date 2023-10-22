package edu.hw2.Task2_2;

public class Rectangle {
    private int width;
    private int lenght;
    public Rectangle() {
    }
    public double getLength() {
        return lenght;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle setWidth(int width) {
        Rectangle ret = new Rectangle();
        ret.lenght = this.lenght;
        ret.width = width;
        return ret;
    }

    public Rectangle setLenght(int lenght) {
        Rectangle ret = new Rectangle();
        ret.lenght = lenght;
        ret.width = this.width;
        return ret;
    }
    public double area() {
        return width * lenght;
    }
}
