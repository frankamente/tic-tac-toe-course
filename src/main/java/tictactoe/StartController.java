package tictactoe;

public class StartController extends Controller {
    protected StartController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        this.getBoard().write();
        this.setState(State.IN_GAME);
    }
}
