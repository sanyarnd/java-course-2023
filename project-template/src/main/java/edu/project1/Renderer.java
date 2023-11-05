package edu.project1;

import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinate> path);
}
