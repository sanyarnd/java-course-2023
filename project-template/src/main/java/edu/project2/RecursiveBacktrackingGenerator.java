package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RecursiveBacktrackingGenerator implements Generator {
    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];

        // Инициализация сетки
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }

        Stack<Coordinate> stack = new Stack<>();
        Random random = new Random();
        int startX = random.nextInt(width);
        int startY = random.nextInt(height);

        stack.push(new Coordinate(startY, startX));
        grid[startY][startX] = new Cell(startY, startX, Cell.Type.PASSAGE);

        while (!stack.isEmpty()) {
            Coordinate current = stack.peek();
            List<Direction> directions = getShuffledDirections();

            boolean hasUnvisitedNeighbor = false;

            for (Direction direction : directions) {
                int newRow = current.row() + direction.getRowOffset() * 2;
                int newCol = current.col() + direction.getColOffset() * 2;

                if (isValidCell(grid, newRow, newCol)) {
                    hasUnvisitedNeighbor = true;
                    grid[newRow][newCol] = new Cell(newRow, newCol, Cell.Type.PASSAGE);
                    grid[current.row() + direction.getRowOffset()][current.col() + direction.getColOffset()] = new Cell(current.row() + direction.getRowOffset(), current.col() + direction.getColOffset(), Cell.Type.PASSAGE);

                    stack.push(new Coordinate(newRow, newCol));
                    break;
                }
            }

            if (!hasUnvisitedNeighbor) {
                stack.pop();
            }
        }

        return new Maze(height, width, grid);
    }

    private List<Direction> getShuffledDirections() {
        List<Direction> directions = new ArrayList<>(List.of(Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT));
        Collections.shuffle(directions);
        return directions;
    }

    private boolean isValidCell(Cell[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col].getType() == Cell.Type.WALL;
    }
}
