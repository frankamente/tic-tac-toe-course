package tictactoe;

public abstract class PutController extends ColocateController {

    public PutController(Game game) {
        super(game, "Pone");
    }

    @Override
    protected void colocate() {
        this.put("En");
    }

    @Override
    protected abstract TicTacToeCoordinate selectTarget(String targetTitle);
}
