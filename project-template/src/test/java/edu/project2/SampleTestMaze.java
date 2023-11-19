package edu.project2;

import edu.hw4.Animal;
import edu.project2.Components.Cell;
import edu.project2.Components.Coordinates;
import edu.project2.Components.Maze;
import edu.project2.Interfaces.Generator;
import edu.project2.Interfaces.Renderer;
import edu.project2.MazeLogic.ConsoleInterpreter;
import edu.project2.MazeLogic.MazeGenerator;
import edu.project2.MazeLogic.MazeSolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SampleTestMaze {
    Maze maze = new Maze(3, 3, new Cell[][] {
        new Cell[] {new Cell(0, 0, Cell.Type.HALLWAY),
            new Cell(0, 1, Cell.Type.WALL),
            new Cell(0, 2, Cell.Type.HALLWAY)},
        new Cell[] {new Cell(1, 0, Cell.Type.HALLWAY),
            new Cell(1, 1, Cell.Type.WALL),
            new Cell(1, 2, Cell.Type.HALLWAY)},
        new Cell[] {new Cell(2, 0, Cell.Type.HALLWAY),
            new Cell(2, 1, Cell.Type.HALLWAY),
            new Cell(2, 2, Cell.Type.HALLWAY)}
    });

    @ParameterizedTest
    @MethodSource("dataForConsoleInterpreter")
    @DisplayName("Тест на консольный интерпритатор")
    void consoleInterpreter_validInputArrayList_successTest(Cell[][] grid, String input1, String input2) {
        String res = input1 + input2;

        Maze maze = new Maze(2, 2, grid);
        Renderer result = new ConsoleInterpreter();

        assertEquals(res, result.render(maze));
    }

    private static Stream<Arguments> dataForConsoleInterpreter() {
        return Stream.of(
            Arguments.of(
                new Cell[][] {
                    {new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.HALLWAY)},
                    {new Cell(1, 0, Cell.Type.HALLWAY), new Cell(1, 1, Cell.Type.WALL)}},
                "X \n", " X\n"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMazeSolver")
    @DisplayName("Тест на решение лабиринта")
    void mazeSolver_validInputArrayList_successTest(List<Coordinates> coordinates) {
        MazeSolver solver = new MazeSolver();

        assertEquals(coordinates, solver.solve(maze, new Coordinates(0, 0), new Coordinates(0, 2)));
    }

    private static Stream<Arguments> dataForMazeSolver() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                    new Coordinates(0, 0), new Coordinates(1, 0),
                    new Coordinates(2, 0), new Coordinates(2, 1), new Coordinates(2, 2),
                    new Coordinates(1, 2), new Coordinates(0, 2)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMazeGenerator")
    @DisplayName("Тест на генератор лабиринта")
    void mazeGenerator_validInputArrayList_successTest(int height, int width) {
        Random random = new Random();
        Generator generator = new MazeGenerator(random);
        Maze maze = generator.generate(height, width);
        assertNotNull(maze);
    }

    private static Stream<Arguments> dataForMazeGenerator() {
        return Stream.of(
            Arguments.of(15, 2),
            Arguments.of(20, 96)
        );
    }
}
