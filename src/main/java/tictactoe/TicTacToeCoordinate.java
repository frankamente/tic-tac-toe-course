package tictactoe;

public class TicTacToeCoordinate extends Coordinate{

    public static final int DIMENSION = 3;

    public TicTacToeCoordinate() {
    }

    public TicTacToeCoordinate(int row, int column) {
        super.setRow(row);
        super.setColumn(column);
    }

    public void read(String title) {
        IO io = new IO();
        io.writeln(title + " qué casilla?");
        this.setRow(new LimitedIntDialog("Fila?", 1, TicTacToeCoordinate.DIMENSION).read() - 1);
        this.setColumn(new LimitedIntDialog("Columna?", 1, TicTacToeCoordinate.DIMENSION).read() - 1);
    }

    public Direction direction(TicTacToeCoordinate coordinate) {
        Direction direction = super.direction(coordinate);
        if (direction == Direction.NON_EXISTENT) {
            if (this.inInverse() && coordinate.inInverse()) {
                return Direction.INVERSE;
            }
        }
        return Direction.NON_EXISTENT;
    }

    private boolean inInverse() {
        return this.getRow() + this.getColumn() == TicTacToeCoordinate.DIMENSION - 1;
    }
}
