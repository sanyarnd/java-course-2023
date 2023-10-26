package edu.hw2.task2;

public class Square extends Rectangle {
    int superWidth;
    int superHeight;

    @Override
    int setWidth(int width) {
        superWidth = super.setWidth(width);
        if (superHeight == 0) {
            super.setHeight(width);
        }
        return width;
    }

    @Override
    int setHeight(int height) {
        super.setHeight(height);
        if (superWidth == 0) {
            super.setWidth(height);
        }
        return height;
    }
}
