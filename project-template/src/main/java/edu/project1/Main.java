package edu.project1;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Generator generator = new PrimsGenerator();
        Solver solver = new DepthFirstSolver();
        Renderer renderer = new ConsoleRenderer();

        Maze maze = generator.generate(10, 10);
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(9, 9);

        List<Coordinate> path = solver.solve(maze, start, end);

        String mazeOutput = renderer.render(maze);
        String pathOutput = renderer.render(maze, path);

        System.out.println("Maze:");
        System.out.println(mazeOutput);
        System.out.println("Path:");
        System.out.println(pathOutput);
    }
}

