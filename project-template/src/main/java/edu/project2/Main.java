package edu.project2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Генерация лабиринта
        Generator generator = new RecursiveBacktrackingGenerator();
        Maze maze = generator.generate(10,  10);

        // Отображение сгенерированного лабиринта
        System.out.println("Generated Maze:");
        Renderer renderer = new ConsoleMazeRenderer();
        System.out.println(renderer.render(maze));

        // Задание начальной и конечной координат для решения лабиринта
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(maze.getHeight() - 1, maze.getWidth() - 1);

        // Решение лабиринта
        Solver solver = new DepthFirstSearchSolver();
        List<Coordinate> solution = solver.solve(maze, start, end);

        // Отображение лабиринта с найденным путем
        System.out.println("Maze with Solution:");
        System.out.println(renderer.render(maze, solution));
    }
}
