package edu.project2.MazeLogic;

import edu.project2.Components.Cell;
import edu.project2.Components.Coordinates;
import edu.project2.Components.Maze;
import edu.project2.Interfaces.Renderer;
import java.util.List;

public class ConsoleInterpreter implements Renderer {
    private static final String WALL_SYMBOL = "X";
    private static final String HALLWAY_SYMBOL = " ";
    private static final String PATH_SYMBOL = "+";

    @Override
    //отрисовываем лабиринт
    public String render(Maze maze) {
        StringBuilder curRender = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell cell = maze.getGrid()[row][col];
                curRender.append(cell.type() == Cell.Type.WALL ? WALL_SYMBOL : HALLWAY_SYMBOL);
            }
            curRender.append("\n");
        }
        return curRender.toString();
    }

    @Override
    //отрисовываем лабиринт с путем
    public String render(Maze maze, List<Coordinates> path) {
        StringBuilder curRender = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Coordinates coordinate = new Coordinates(row, col);
                if (path.contains(coordinate)) {
                    curRender.append(PATH_SYMBOL);
                } else {
                    Cell cell = maze.getGrid()[row][col];
                    curRender.append(cell.type() == Cell.Type.WALL ? WALL_SYMBOL : HALLWAY_SYMBOL);
                }
            }
            curRender.append("\n");
        }
        return curRender.toString();
    }
}
