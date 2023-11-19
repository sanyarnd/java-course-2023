package edu.project2.MazeLogic;

import edu.project2.Components.Cell;
import edu.project2.Components.Coordinates;
import edu.project2.Components.Maze;
import edu.project2.Interfaces.Generator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator implements Generator {
    private final Random random;

    public MazeGenerator(Random random) {
        this.random = random;
    }

    @Override
    //генерируем лабиринт
    public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }

        for (int row = 0; row < height - 2; row += 2) {
            for (int col = 0; col < width - 2; col += 2) {
                if (random.nextBoolean()) {
                    int hallwayWidth = 1;
                    int hallwayStart = random.nextInt(width - col - hallwayWidth) + col;
                    for (int i = hallwayStart; i < hallwayStart + hallwayWidth; i++) {
                        grid[row][i] = new Cell(row, i, Cell.Type.HALLWAY);
                    }
                } else {
                    int hallwayWidth = 1;
                    int hallwayStart = random.nextInt(height - row - hallwayWidth) + row;
                    for (int i = hallwayStart; i < hallwayStart + hallwayWidth; i++) {
                        grid[i][col] = new Cell(i, col, Cell.Type.HALLWAY);
                    }
                }
            }
        }

        Stack<Coordinates> stack = new Stack<>();
        Coordinates start = new Coordinates(1, 1);
        stack.push(start);

        while (!stack.isEmpty()) {
            Coordinates current = stack.pop();
            List<Coordinates> neighbors = getNeighbors(current, grid);
            if (!neighbors.isEmpty()) {
                stack.push(current);
                Collections.shuffle(neighbors, random);
                Coordinates neighbor = neighbors.get(0);
                int row = (current.row() + neighbor.row()) / 2;
                int col = (current.col() + neighbor.col()) / 2;
                grid[row][col] = new Cell(row, col, Cell.Type.HALLWAY);
                grid[neighbor.row()][neighbor.col()] = new Cell(neighbor.row(), neighbor.col(), Cell.Type.HALLWAY);
                stack.push(neighbor);
            }
        }
        return new Maze(height, width, grid);
    }

    //проверяем соседние ячейки
    public List<Coordinates> getNeighbors(Coordinates current, Cell[][] grid) {
        List<Coordinates> neighbors = new ArrayList<>();
        int row = current.row();
        int col = current.col();
        if (row > 1 && grid[row - 2][col].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinates(row - 2, col));
        }
        if (row < grid.length - 2 && grid[row + 2][col].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinates(row + 2, col));
        }
        if (col > 1 && grid[row][col - 2].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinates(row, col - 2));
        }
        if (col < grid[0].length - 2 && grid[row][col + 2].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinates(row, col + 2));
        }
        return neighbors;
    }
}
