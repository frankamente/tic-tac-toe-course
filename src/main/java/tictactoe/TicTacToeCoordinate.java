package tictactoe;

import java.util.Objects;

public class TicTacToeCoordinate {

    public static final int DIMENSION = 3;
    private final Coordinate coordinate;

    public TicTacToeCoordinate() {
        coordinate = new Coordinate();
    }

    public TicTacToeCoordinate(int row, int column) {
        coordinate = new Coordinate(row, column);
    }

    public void read(String title) {
        IO io = new IO();
        io.writeln(title + " qué casilla?");
        coordinate.setRow(new LimitedIntDialog("Fila?", 1, TicTacToeCoordinate.DIMENSION).read() - 1);
        coordinate.setColumn(new LimitedIntDialog("Columna?", 1, TicTacToeCoordinate.DIMENSION).read() - 1);
    }

    public Direction direction(TicTacToeCoordinate ticTacToeCoordinate) {
        Direction direction = coordinate.direction(ticTacToeCoordinate.coordinate);
        if (direction == Direction.NON_EXISTENT) {
            if (this.inInverse() && ticTacToeCoordinate.inInverse()) {
                return Direction.INVERSE;
            }
        }
        return Direction.NON_EXISTENT;
    }

    private boolean inInverse() {
        return coordinate.getRow() + coordinate.getColumn() == TicTacToeCoordinate.DIMENSION - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToeCoordinate that = (TicTacToeCoordinate) o;
        return coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
