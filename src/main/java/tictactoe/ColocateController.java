package tictactoe;

public abstract class ColocateController {


    private final Turn turn;
    private final Board board;

    private TicTacToeCoordinate target;

    public ColocateController(Turn turn, Board board) {
        this.turn = turn;
        this.board = board;
        this.target = new TicTacToeCoordinate();
    }

    public abstract void control();

    protected void put(String actionTitle, String targetTitle) {
        IO io = new IO();
        io.writeln(actionTitle + " el jugador " + turn.take().getValue());
        this.colocate(targetTitle);
        board.write();
        if (board.existTTT(turn.take())) {
            io.writeln("Victoria!!!! Gana el jugador: " + turn.take().getValue());
        } else {
            turn.change();
        }
    }

    protected abstract void colocate(String targetTitle);

    protected void put(String targetTitle) {
        target = new TicTacToeCoordinate();
        Error error;
        do {
            target.read(targetTitle);
            error = this.errorToPut();
            if (error != null) {
                new IO().writeln(error.toString());
            }
        } while (error != null);
        board.put(target, turn.take());
    }

    protected Error errorToPut() {
        if (!board.empty(target)) {
            return Error.NOT_EMPTY;
        }
        return null;
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
