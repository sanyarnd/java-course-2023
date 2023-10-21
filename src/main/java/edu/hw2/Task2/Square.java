package edu.hw2.Task2;

public final class Square implements Shape {
    private final Shape shape;

    @Override
    public void setWidth(int width) {
        shape.setWidth(width);
        shape.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        shape.setWidth(height);
        shape.setHeight(height);
    }

    @Override
    public int getHeight() {
        return shape.getHeight();
    }

    @Override
    public int getWidth() {
        return shape.getWidth();
    }

    @Override
    public double area() {
        return shape.area();
    }

    public Square() {
        this.shape = new Rectangle();
    }
}
