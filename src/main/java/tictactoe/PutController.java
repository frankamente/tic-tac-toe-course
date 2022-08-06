package tictactoe;

public class PutController {

    private final Turn turn;
    private final Board board;

    public PutController(Turn turn, Board board) {

        this.turn = turn;
        this.board = board;
    }

    public void put() {
        IO io = new IO();
        io.writeln("Pone el jugador " + turn.take().getValue());
        TicTacToeCoordinate target = new TicTacToeCoordinate();
        boolean ok;
        do {
            target.read("En");
            ok = board.empty(target);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        board.put(target, turn.take());
        board.write();
        if (board.existTTT(turn.take())) {
            io.writeln("Victoria!!!! Gana el jugador: " + turn.take().getValue());
        } else {
            turn.change();
        }
    }
}
