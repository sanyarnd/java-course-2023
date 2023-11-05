package edu.project2;

import java.util.ArrayList;
import java.util.List;

public final class Maze {
    private int height;
    private int width;
    private final Cell[][] grid;

    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, CellType.WALL);
            }
        }
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
            return grid[row][col];
        } else {
            throw new IllegalArgumentException("Incorrect cell coordinates");
        }
    }

    public List<Cell> getUnvisitedNeighbors(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();
        List<Cell> neighbors = getNeighbors(row, col, 2);
        List<Cell> unvisitedNeighbors = new ArrayList<>();

        for (Cell neighbor : neighbors) {
            if (neighbor.getType() == CellType.WALL) {
                unvisitedNeighbors.add(neighbor);
            }
        }

        return unvisitedNeighbors;
    }

    public List<Cell> getNeighbors(int row, int col, int dist) {
        List<Cell> neighbors = new ArrayList<>();

        if (isValidCell(row - dist, col)) {
            neighbors.add(grid[row - dist][col]);
        }
        if (isValidCell(row + dist, col)) {
            neighbors.add(grid[row + dist][col]);
        }
        if (isValidCell(row, col - dist)) {
            neighbors.add(grid[row][col - dist]);
        }
        if (isValidCell(row, col + dist)) {
            neighbors.add(grid[row][col + dist]);
        }

        return neighbors;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
