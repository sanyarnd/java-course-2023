package edu.project2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DepthFirstSolverTest {

    private static final Logger LOGGER = Logger.getLogger(DepthFirstSolverTest.class.getName());

    @BeforeEach
    public void setup() {
        LOGGER.info("Running a new test case...");
    }

    @ParameterizedTest
    @MethodSource("mazeCoordinatesProvider")
    public void testDepthFirstSolver(Maze maze, Coordinate start, Coordinate end, List<Coordinate> expectedPath) {
        DepthFirstSolver solver = new DepthFirstSolver();
        new ConsoleRenderer(maze);
        List<Coordinate> actualPath = solver.solve(maze, start, end);

        assertThat(actualPath).isEqualTo(expectedPath);
    }

    private static Stream<Arguments> mazeCoordinatesProvider() {
        Maze maze1 = new Maze(5, 5);
        maze1.getCell(1, 1).setType(CellType.PASSAGE);
        maze1.getCell(1, 2).setType(CellType.PASSAGE);
        maze1.getCell(1, 3).setType(CellType.PASSAGE);
        maze1.getCell(2, 3).setType(CellType.PASSAGE);
        maze1.getCell(3, 3).setType(CellType.PASSAGE);
        maze1.getCell(3, 2).setType(CellType.PASSAGE);
        maze1.getCell(3, 1).setType(CellType.PASSAGE);

        List<Coordinate> expectedPath1 = new ArrayList<>(List.of(
            new Coordinate(1, 1),
            new Coordinate(1, 2),
            new Coordinate(1, 3),
            new Coordinate(2, 3),
            new Coordinate(3, 3)
        ));

        return Stream.of(
            arguments(maze1, new Coordinate(1, 1), new Coordinate(3, 3), expectedPath1)
        );
    }
}
