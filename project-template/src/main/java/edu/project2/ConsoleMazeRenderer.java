package edu.project2;

import java.util.List;

public class ConsoleMazeRenderer implements Renderer {
    @Override
    public String render(Maze maze) {
        Cell[][] grid = maze.getGrid();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                result.append(grid[i][j].getType() == Cell.Type.WALL ? "██" : "  ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        Cell[][] grid = maze.getGrid();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Coordinate current = new Coordinate(i, j);
                if (path.contains(current)) {
                    System.out.println("Hello");
                    result.append(" o ");  // Путь
                } else {
                    result.append(grid[i][j].getType() == Cell.Type.WALL ? "██" : "  ");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
