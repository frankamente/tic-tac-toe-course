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

    private void remove(){
        origin = new TicTacToeCoordinate();
        Error error;
        do {
            origin.read("De");
            error = this.errorToRemove();
            if (error != null) {
                new IO().writeln(error.toString());
            }
        } while (error != null);
        this.getBoard().remove(origin);
    }

    private Error errorToRemove() {
        if (!this.getBoard().full(origin, this.getTurn().take())) {
            return Error.NOT_PROPERTY;
        }
        return null;
    }

    @Override
    protected Error errorToPut() {
        Error error = super.errorToPut();
        if (error != null) {
            if (origin.equals(this.getTarget())) {
                return Error.REPEATED_COORDINATED;
            }
        }
        return error;
    }
}
