package tictactoe;

import java.util.Objects;

public class Coordinate {

    public static final int DIMENSION = 3;

    private int row;
    private int column;

    public Coordinate() {
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void read(String title) {
        IO io = new IO();
        io.writeln(title + " qué casilla?");
        row = new LimitedIntDialog("Fila?", 1, Coordinate.DIMENSION).read() - 1;
        column = new LimitedIntDialog("Columna?", 1, Coordinate.DIMENSION).read() - 1;
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

        if (this.inInverse() && coordinate.inInverse()) {
            return Direction.INVERSE;
        }
        return Direction.NON_EXISTENT;
    }

    private boolean inDiagonal() {
        return row - column == 0;
    }

    private boolean inInverse() {
        return row + column == 2;
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
}
