package tictactoe;

public abstract class ColocateController extends Controller {

    private final String actionTitle;
    private TicTacToeCoordinate target;

    public ColocateController(Game game, String actionTitle) {
        super(game);
        this.actionTitle = actionTitle;
        this.target = new TicTacToeCoordinate();
    }

    public void control() {
        IO io = new IO();
        io.writeln(actionTitle + " el jugador " + this.getTurn().take().getValue());
        this.colocate();
        this.getBoard().write();
        if (this.getBoard().existTTT(this.getTurn().take())) {
            io.writeln("Victoria!!!! Gana el jugador: " + this.getTurn().take().getValue());
            this.setState(State.FINAL);
        } else {
            this.getTurn().change();
        }
    }

    protected abstract void colocate();

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
        this.getBoard().put(target, this.getTurn().take());
    }

    protected Error errorToPut() {
        if (!this.getBoard().empty(target)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }

    public TicTacToeCoordinate getTarget() {
        return target;
    }
}
