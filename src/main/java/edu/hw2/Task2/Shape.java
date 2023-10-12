package edu.hw2.Task2;

public sealed interface Shape permits Rectangle, Square {
    void setWidth(int width);

    void setHeight(int height);

    int getHeight();

    int getWidth();

    double area();
}

