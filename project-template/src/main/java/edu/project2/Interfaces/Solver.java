package edu.project2.Interfaces;

import edu.project2.Components.Coordinates;
import edu.project2.Components.Maze;
import java.util.List;

public interface Solver {
    List<Coordinates> solve(Maze maze, Coordinates start, Coordinates end);
}
