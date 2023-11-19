package edu.project2.Interfaces;

import edu.project2.Components.Coordinates;
import edu.project2.Components.Maze;
import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinates> path);
}
