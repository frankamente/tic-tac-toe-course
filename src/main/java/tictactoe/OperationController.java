package tictactoe;

public abstract class OperationController extends Controller {
    protected OperationController(Game game) {
        super(game);
    }

    public abstract void control();
}
