package edu.project2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BreadthFirstGeneratorTest {
    private static final Logger LOGGER = Logger.getLogger(DepthFirstSolverTest.class.getName());

    @BeforeEach
    public void setup() {
        LOGGER.info("Running a new test case...");
    }

    @ParameterizedTest
    @CsvSource({"13, 13", "17, 17"})
    void generateMazeSecondApproach(int height, int width) {
        BFSGenerator generator = new BFSGenerator();
        Maze maze = generator.generate(height, width);
        new ConsoleRenderer(maze);
        assertNotNull(maze);
        assertEquals(height, maze.getHeight());
        assertEquals(width, maze.getWidth());

        int passageCount = 0;
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell cell = maze.getCell(row, col);
                assertNotNull(cell);
                assertTrue(cell.getType() == CellType.PASSAGE || cell.getType() == CellType.WALL);

                if (cell.getType() == CellType.PASSAGE) {
                    passageCount++;
                }
            }
        }
        assertTrue(passageCount >= 2);
    }

    @Test
    void removeWall() {
        DepthFirstGenerator generator = new DepthFirstGenerator();
        Maze maze = new Maze(3, 3);
        Cell first = maze.getCell(0, 0);
        Cell second = maze.getCell(0, 2);
        Cell middle = maze.getCell(0, 1);

        generator.removeWall(first, second, maze);
        assertEquals(CellType.PASSAGE, maze.getCell(0, 1).getType());
    }
}
