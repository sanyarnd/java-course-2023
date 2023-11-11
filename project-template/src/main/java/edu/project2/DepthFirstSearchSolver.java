package edu.project2;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        Cell[][] grid = maze.getGrid();
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        List<Coordinate> path = new ArrayList<>();

        dfs(grid, visited, start, end, path);

        return path;
    }

    private boolean dfs(Cell[][] grid, boolean[][] visited, Coordinate current, Coordinate end, List<Coordinate> path) {
        int row = current.row();
        int col = current.col();

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col].getType() == Cell.Type.WALL) {
            return false;
        }

        visited[row][col] = true;
        path.add(current);

        if (current.equals(end)) {
            return true;  // Путь найден
        }

        if (dfs(grid, visited, new Coordinate(row - 1, col), end, path) ||
            dfs(grid, visited, new Coordinate(row + 1, col), end, path) ||
            dfs(grid, visited, new Coordinate(row, col - 1), end, path) ||
            dfs(grid, visited, new Coordinate(row, col + 1), end, path)) {
            return true;
        }

        // Возврат назад
        path.remove(path.size() - 1);
        return false;
    }
}
