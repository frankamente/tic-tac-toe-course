package tictactoe.models;

import tictactoe.utils.Direction;
import tictactoe.utils.IO;
import tictactoe.utils.LimitedIntDialog;

import java.util.Objects;
import java.util.Random;

public class Coordinate {

    public static final int DIMENSION = 3;
    private final tictactoe.utils.Coordinate coordinate;

    public Coordinate() {
        coordinate = new tictactoe.utils.Coordinate();
    }

    public Coordinate(int row, int column) {
        coordinate = new tictactoe.utils.Coordinate(row, column);
    }

    public void read(String title) {
        IO io = new IO();
        io.writeln(title + " qué casilla?");
        coordinate.setRow(new LimitedIntDialog("Fila?", 1, Coordinate.DIMENSION).read() - 1);
        coordinate.setColumn(new LimitedIntDialog("Columna?", 1, Coordinate.DIMENSION).read() - 1);
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        coordinate.setRow(random.nextInt(Coordinate.DIMENSION));
        coordinate.setColumn(random.nextInt(Coordinate.DIMENSION));
    }

    public Direction direction(Coordinate coordinate) {
        Direction direction = this.coordinate.direction(coordinate.coordinate);
        if (direction == Direction.NON_EXISTENT) {
            if (this.inInverse() && coordinate.inInverse()) {
                return Direction.INVERSE;
            }
        }
        return direction;
    }

    private boolean inInverse() {
        return coordinate.getRow() + coordinate.getColumn() == Coordinate.DIMENSION - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }

    @Override
    public String toString() {
        return coordinate.toString();
    }
}
