package tictactoe;

public class Coordinate {
    private int row;
    private int column;

    public void read(String title) {
        IO io = new IO();
        io.writeln(title + " qué casilla?");
        do {
            row = io.readInt("Fila? [1," + Board.DIMENSION + "]: ");
        } while (row < 1 || Board.DIMENSION < row);
        do {
            column = io.readInt("Columna? [1," + Board.DIMENSION + "]: ");
        } while (column < 1 || Board.DIMENSION < column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
