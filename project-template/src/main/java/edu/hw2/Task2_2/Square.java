package edu.hw2.Task2_2;
public class Square extends Rectangle {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    @Override
    public Rectangle setLenght(int lenght) {
        return super.setWidth(lenght).setLenght(lenght);
    }
    @Override
    public Rectangle setWidth(int width) {
        return super.setWidth(width).setLenght(width);
    }

    @Override
    public double getLength() {
        return getSide();
    }

    @Override
    public double getWidth() {
        return getSide();
    }
}
