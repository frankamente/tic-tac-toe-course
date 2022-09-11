package tictactoe;

public abstract class ColocateController {


    private final Game game;

    private TicTacToeCoordinate target;

    public ColocateController(Game game) {
        this.game = game;
        this.target = new TicTacToeCoordinate();
    }

    public abstract void control();

    protected void put(String actionTitle, String targetTitle) {
        IO io = new IO();
        io.writeln(actionTitle + " el jugador " + game.getTurn().take().getValue());
        this.colocate(targetTitle);
        game.getBoard().write();
        if (game.getBoard().existTTT(game.getTurn().take())) {
            io.writeln("Victoria!!!! Gana el jugador: " + game.getTurn().take().getValue());
        } else {
            game.getTurn().change();
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
        game.getBoard().put(target, game.getTurn().take());
    }

    protected Error errorToPut() {
        if (!game.getBoard().empty(target)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }

    public Turn getTurn() {
        return game.getTurn();
    }

    public Board getBoard() {
        return game.getBoard();
    }

    public TicTacToeCoordinate getTarget() {
        return target;
    }
}
