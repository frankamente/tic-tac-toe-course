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
        put(board, "En");
    }

    public void move(Board board) {
        IO io = new IO();
        io.writeln("Mueve el jugador " + color.getColor());
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
        this.put(board, "A");
    }

    private void put(Board board, String title) {
        IO io = new IO();
        Coordinate coordinate = new Coordinate();
        boolean ok;
        do {
            coordinate.read(title);
            ok = board.empty(coordinate);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        board.put(coordinate, color);
    }

    public void win() {
        IO io = new IO();
        io.writeln("Victoria!!!! Gana el jugador: " + color.getColor());
    }
}
