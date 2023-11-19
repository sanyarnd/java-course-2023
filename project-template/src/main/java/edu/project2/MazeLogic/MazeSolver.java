package edu.project2.MazeLogic;

import edu.project2.Components.Cell;
import edu.project2.Components.Coordinates;
import edu.project2.Components.Maze;
import edu.project2.Interfaces.Solver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MazeSolver implements Solver {
    private final List<Coordinates> directions = Arrays.asList(
        //движение по ячейкам
        new Coordinates(-1, 0),
        new Coordinates(0, 1),
        new Coordinates(1, 0),
        new Coordinates(0, -1)
    );

    @Override
    //ищем решение в нашем лабиринте
    public List<Coordinates> solve(Maze maze, Coordinates start, Coordinates end) {
        List<Coordinates> path = new ArrayList<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Queue<Coordinates> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            if (current.equals(end)) {
                path.add(current);
                while (!current.equals(start)) {
                    path.add(parentMap.get(current));
                    current = parentMap.get(current);
                }
                Collections.reverse(path);
                break;
            }
            for (Coordinates direction : directions) {
                Coordinates neighbor =
                    new Coordinates(
                        current.row() + direction.row(),
                        current.col() + direction.col()
                    );
                if (isValid(neighbor, maze) && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        return path;
    }

    private boolean isValid(Coordinates coordinate, Maze maze) {
        int row = coordinate.row();
        int col = coordinate.col();
        return row >= 0 && row < maze.getHeight()
            && col >= 0 && col < maze.getWidth()
            && maze.getGrid()[row][col].type() == Cell.Type.HALLWAY;
    }
}
