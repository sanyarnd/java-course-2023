package edu.project2;

import java.util.Objects;

public class Cell {

    private final int row;
    private final int col;
    private CellType type;
    private Cell parent;

    public Cell(int row, int col, CellType type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.parent = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col && type == cell.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, type);
    }
}
