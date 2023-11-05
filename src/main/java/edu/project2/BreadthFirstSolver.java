package edu.project2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        Cell startCell = maze.getCell(start.row(), start.col());
        Cell endCell = maze.getCell(end.row(), end.col());

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(startCell);

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            if (currentCell.equals(endCell)) {
                return reconstructPath(currentCell);
            }

            currentCell.setType(CellType.VISITED);

            List<Cell> neighbors = maze.getNeighbors(currentCell.getRow(), currentCell.getCol(), 1);
            for (Cell neighbor : neighbors) {
                if (neighbor.getType() == CellType.PASSAGE) {
                    queue.offer(neighbor);
                    neighbor.setParent(currentCell);
                }
            }
        }

        return null;
    }

    private List<Coordinate> reconstructPath(Cell endCell) {
        List<Coordinate> path = new LinkedList<>();
        Cell current = endCell;

        while (current != null) {
            path.add(new Coordinate(current.getRow(), current.getCol()));
            current = current.getParent();
        }

        // reverse the path to start from the beginning
        Collections.reverse(path);
        return path;
    }
}
