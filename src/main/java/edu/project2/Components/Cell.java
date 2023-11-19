package edu.project2.Components;

public record Cell(int row, int col, Type type) {
    public enum Type {WALL, HALLWAY}
}
