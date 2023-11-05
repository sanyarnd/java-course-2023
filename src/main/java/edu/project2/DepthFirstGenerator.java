package edu.project2;

import java.util.List;
import java.util.Stack;

public class DepthFirstGenerator implements Generator {

    @Override
    public Maze generate(int height, int width) {
        Maze maze = new Maze(height, width);
        Stack<Cell> stack = new Stack<>();
        Cell startCell = maze.getCell(1, 1);
        startCell.setType(CellType.PASSAGE);
        stack.push(startCell);

        while (!stack.isEmpty()) {
            Cell currentCell = stack.pop();
            List<Cell> neighbors = maze.getUnvisitedNeighbors(currentCell);

            if (!neighbors.isEmpty()) {
                stack.push(currentCell);
                Cell randomNeighbor = neighbors.get((int) (Math.random() * neighbors.size()));
                removeWall(currentCell, randomNeighbor, maze);
                randomNeighbor.setType(CellType.PASSAGE);
                stack.push(randomNeighbor);
            }
        }

        return maze;
    }

    public void removeWall(Cell first, Cell second, Maze maze) {
        int xDiff = second.getCol() - first.getCol();
        int yDiff = second.getRow() - first.getRow();
        int addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
        int addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

        Cell target = new Cell(first.getRow() + addY, first.getCol() + addX, CellType.PASSAGE);
        maze.getCell(target.getRow(), target.getCol()).setType(CellType.PASSAGE);
    }
}




