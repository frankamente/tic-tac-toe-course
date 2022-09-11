package tictactoe;

public class MoveController extends ColocateController {

    private TicTacToeCoordinate origin;

    public MoveController(Game game) {
        super(game, "Mueve");
        origin = new TicTacToeCoordinate();
    }

    @Override
    protected void colocate() {
        this.remove();
        this.put("A");
    }

    private void remove() {
        Error error;
        do {
            origin = this.selectOrigin();
            error = this.validateOrigin();
            if (error != null) {
                new IO().writeln(error.toString());
            }
        } while (error != null);
        this.getBoard().remove(origin, this.getTurn().take());
    }

    private TicTacToeCoordinate selectOrigin() {
        TicTacToeCoordinate origin = new TicTacToeCoordinate();
        origin.read("De");
        return origin;
    }

    private Error validateOrigin() {
        if (!this.getBoard().full(origin, this.getTurn().take())) {
            return Error.NOT_PROPERTY;
        }
        return null;
    }

    @Override
    protected Error validateTarget() {
        Error error = super.validateTarget();
        if (error != null) {
            return error;
        }
        if (origin.equals(this.getTarget())) {
            return Error.REPEATED_COORDINATE;
        }
        return null;
    }

    @Override
    protected TicTacToeCoordinate selectTarget(String targetTitle) {
        TicTacToeCoordinate target = new TicTacToeCoordinate();
        target.read(targetTitle);
        return target;
    }
}
