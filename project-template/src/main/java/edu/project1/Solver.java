package edu.project1;

import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
