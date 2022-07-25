package tictactoe;

import java.util.Objects;

public class Coordinate {
    private int row;
    private int column;

    public void read(String title) {
        IO io = new IO();
        io.writeln(title + " qué casilla?");
        row = new LimitedIntDialog("Fila?", 1, Board.DIMENSION).read() - 1;
        column = new LimitedIntDialog("Columna?", 1, Board.DIMENSION).read() - 1;
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
