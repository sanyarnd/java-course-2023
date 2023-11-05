package edu.project2;

/** @noinspection CheckStyle */
public final class ConsoleRenderer implements Renderer {

    public ConsoleRenderer(Maze maze) {
        render(maze);
    }

    @Override
    public String render(Maze maze) {
        StringBuilder renderedMaze = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell cell = maze.getCell(row, col);
                if (cell.getType() == CellType.WALL) {
                    renderedMaze.append("\u001B[41m   "); // red
                    if (col == maze.getWidth() - 1 && maze.getHeight() % 2 == 0) {  // even height/width
                        renderedMaze.append("\u001B[41m   ");
                    }

                } else {
                    renderedMaze.append("\u001B[40m   "); // black
                    if (col == maze.getWidth() - 1 && maze.getHeight() % 2 == 0) {  // even height/width
                        renderedMaze.append("\u001B[41m   ");
                    }
                }
            }

            renderedMaze.append("\u001B[0m\n"); // ANSI color reset for new row
            if (row == maze.getWidth() - 1 && maze.getHeight() % 2 == 0) { // even height/width
                for (int i = 0; i <= maze.getWidth(); i++) {
                    renderedMaze.append("\u001B[41m   ");
                    renderedMaze.append("\u001B[0m");
                }

            }
        }

        System.out.println(renderedMaze);
        return renderedMaze.toString();
    }

}
