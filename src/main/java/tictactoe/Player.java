package tictactoe;

public class Player {

    private final Color color;
    private final Board board;

    public Player(int i, Board board) {
        this.board = board;
        if (i == 0) {
            color = Color.X;
        } else {
            color = Color.O;
        }
    }

    public void put() {
        IO io = new IO();
        io.writeln("Pone el jugador " + color.getValue());
        this.put("En", null);
    }

    public void move() {
        IO io = new IO();
        io.writeln("Mueve el jugador " + color.getValue());
        Coordinate origin = new Coordinate();
        boolean ok;
        do {
            origin.read("De");
            ok = board.full(origin, color);
            if (!ok) {
                io.writeln("Esa casilla no está ocupada por ninguna de tus fichas");
            }
        } while (!ok);
        board.remove(origin);
        this.put("A", origin);
    }

    private void put(String title, Coordinate forbiddenCoordinate) {
        IO io = new IO();
        Coordinate target = new Coordinate();
        boolean ok;
        do {
            target.read(title);
            ok = board.empty(target);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
            if (ok && target.equals(forbiddenCoordinate)) {
                io.writeln("No se puede poner en el mismo lugar en el que estaba");
            }
        } while (!ok);
        board.put(target, color);
    }

    public void win() {
        IO io = new IO();
        io.writeln("Victoria!!!! Gana el jugador: " + color.getValue());
    }
}
