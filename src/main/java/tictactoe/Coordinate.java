package tictactoe;

import java.util.Objects;

public class Coordinate {

    private int row;
    private int column;

    public Coordinate() {
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Direction direction(Coordinate coordinate) {
        if (this.getRow() == coordinate.getRow()) {
            return Direction.HORIZONTAL;
        }

        if (this.getColumn() == coordinate.getColumn()) {
            return Direction.VERTICAL;
        }

        if (this.inDiagonal() && coordinate.inDiagonal()) {
            return Direction.DIAGONAL;
        }
        return Direction.NON_EXISTENT;
    }

    private boolean inDiagonal() {
        return row - column == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    protected void setRow(int row) {
        this.row = row;
    }

    protected void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + (row + 1) + ", " + (column + 1) + ')';
    }
}
