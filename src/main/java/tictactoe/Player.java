package tictactoe;

public class Player {

    private final Color color;

    public Player(int i) {
        if (i == 0) {
            color = Color.X;
        } else {
            color = Color.O;
        }
    }

    public void put(Board board) {
        IO io = new IO();
        io.writeln("Pone el jugador " + color.getColor());
        int row;
        int column;
        boolean ok;
        do {
            io.writeln("En qué casilla?");
            do {
                row = io.readInt("Fila? [1," + Board.DIMENSION + "]: ");
            } while (row < 1 || Board.DIMENSION < row);
            do {
                column = io.readInt("Columna? [1," + Board.DIMENSION + "]: ");
            } while (column < 1 || Board.DIMENSION < column);
            ok = board.empty(row - 1, column - 1);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        board.put(row - 1, column - 1, color);
    }

    public void move(Board board) {
        IO io = new IO();
        io.writeln("Mueve el jugador " + color.getColor());
        int originRow;
        int originColumn;
        int targetRow;
        int targetColumn;
        boolean ok;
        do {
            io.writeln("De qué casilla?");
            do {
                originRow = io.readInt("Fila? [1," + Board.DIMENSION + "]: ");
            } while (originRow < 1 || Board.DIMENSION < originRow);
            do {
                originColumn = io.readInt("Columna? [1," + Board.DIMENSION + "]: ");
            } while (1 <= originColumn && originColumn <= Board.DIMENSION);
            ok = board.full(originRow - 1, originColumn - 1, color);
            if (!ok) {
                io.writeln("Esa casilla no está ocupada por ninguna de tus fichas");
            }
        } while (!ok);
        do {
            io.writeln("A qué casilla?");
            do {
                targetRow = io.readInt("Fila? [1," + Board.DIMENSION + "]: ");
            } while (targetRow < 1 || Board.DIMENSION < targetRow);
            do {
                targetColumn = io.readInt("Columna? [1," + Board.DIMENSION + "]: ");
            } while (targetColumn < 1 || Board.DIMENSION < targetColumn);
            ok = board.empty(targetRow - 1, targetColumn - 1);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        board.put(originRow - 1, originColumn - 1, Color.NONE);
        board.put(targetRow - 1, targetColumn - 1, color);
    }

    public void win() {
        IO io = new IO();
        io.writeln("Victoria!!!! Gana el jugador: " + color.getColor());
    }
}
