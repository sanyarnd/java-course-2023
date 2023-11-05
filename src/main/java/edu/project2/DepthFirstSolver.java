package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        Cell startCell = maze.getCell(start.row(), start.col());

        Cell endCell = maze.getCell(end.row(), end.col());

        Stack<Cell> stack = new Stack<>();
        stack.push(startCell);

        while (!stack.isEmpty()) {
            Cell currentCell = stack.pop();
            if (currentCell.equals(endCell)) {
                return reconstructPath(currentCell);
            }

            currentCell.setType(CellType.VISITED);

            List<Cell> neighbors = maze.getNeighbors(currentCell.getRow(), currentCell.getCol(), 1);
            for (Cell neighbor : neighbors) {
                if (neighbor.getType() == CellType.PASSAGE) {
                    stack.push(neighbor);
                    neighbor.setParent(currentCell);
                }
            }
        }
        // No path found
        return null;
    }

    private List<Coordinate> reconstructPath(Cell endCell) {
        List<Coordinate> path = new ArrayList<>();
        Cell current = endCell;

        while (current != null) {
            path.add(new Coordinate(current.getRow(), current.getCol()));
            current = current.getParent();
        }

        // Reverse the path to start from the beginning
        Collections.reverse(path);
        return path;
    }
}
