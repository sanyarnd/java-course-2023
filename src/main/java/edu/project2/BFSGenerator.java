package edu.project2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class BFSGenerator implements Generator {

    @Override
    public Maze generate(int height, int width) {
        Maze maze = new Maze(height, width);
        Random random = new Random();
        Queue<Cell> queue = new LinkedList<>();

        // start BFS from a random cell
        int startRow = 1;
        int startCol = 1;
        Cell startCell = maze.getCell(startRow, startCol);
        startCell.setType(CellType.PASSAGE);
        queue.add(startCell);

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            List<Cell> neighbors = maze.getUnvisitedNeighbors(currentCell);

            // Shuffle the neighbors randomly
            Collections.shuffle(neighbors, random);

            for (Cell neighbor : neighbors) {
                int newRow = neighbor.getRow();
                int newCol = neighbor.getCol();
                if (newCol == 0 || newCol == maze.getWidth() - 1 || newRow == 0 || newRow == maze.getHeight() - 1) {
                    continue;
                }
                // Carve passage to the neighbor
                removeWall(currentCell, neighbor, maze);
                neighbor.setType(CellType.PASSAGE);
                queue.add(maze.getCell(newRow, newCol));
            }
        }

        return maze;
    }

    private void removeWall(Cell first, Cell second, Maze maze) {
        int rowDiff = second.getRow() - first.getRow();
        int colDiff = second.getCol() - first.getCol();
        int addRow = (rowDiff != 0) ? (rowDiff / Math.abs(rowDiff)) : 0;
        int addCol = (colDiff != 0) ? (colDiff / Math.abs(colDiff)) : 0;

        Cell wall = new Cell(first.getRow() + addRow, first.getCol() + addCol, CellType.PASSAGE);
        maze.getCell(wall.getRow(), wall.getCol()).setType(CellType.PASSAGE);
    }
}
