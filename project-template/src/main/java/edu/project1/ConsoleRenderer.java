package edu.project1;

import java.util.List;

public class ConsoleRenderer implements Renderer {
    @Override
    public String render(Maze maze) {
        StringBuilder sb = new StringBuilder();
        // Реализация красивой печати лабиринта в консоль
        return sb.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        StringBuilder sb = new StringBuilder();
        // Реализация красивой печати лабиринта и маршрута в консоль
        return sb.toString();
    }
}
