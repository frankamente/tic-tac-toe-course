package tictactoe;

public class PutController extends ColocateController {

    public PutController(Game game) {
        super(game, "Pone");
    }

    @Override
    protected void colocate() {
        this.put("En");
    }

    @Override
    protected TicTacToeCoordinate selectTarget(String targetTitle) {
        TicTacToeCoordinate target = new TicTacToeCoordinate();
        target.read(targetTitle);
        return target;
    }
}
