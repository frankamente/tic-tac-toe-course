package tictactoe;

public abstract class ColocateController {


    private final Turn turn;
    private final Board board;

    private final TicTacToeCoordinate target;

    public ColocateController(Turn turn, Board board) {
        this.turn = turn;
        this.board = board;
        this.target = new TicTacToeCoordinate();
    }

    public abstract void control();

    protected void put(String actionTitle, String targetTitle) {
        IO io = new IO();
        io.writeln(actionTitle + " el jugador " + turn.take().getValue());
        this.prePut();
        boolean ok;
        do {
            target.read(targetTitle);
            ok = this.errorToPut();
        } while (!ok);
        board.put(target, turn.take());
        board.write();
        if (board.existTTT(turn.take())) {
            io.writeln("Victoria!!!! Gana el jugador: " + turn.take().getValue());
        } else {
            turn.change();
        }
    }

    protected abstract void prePut();

    protected boolean errorToPut() {
        boolean ok;
        ok = board.empty(target);
        if (!ok) {
            new IO().writeln("Esa casilla no está vacía");
        }
        return ok;
    }

    public Turn getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    public TicTacToeCoordinate getTarget() {
        return target;
    }
}
