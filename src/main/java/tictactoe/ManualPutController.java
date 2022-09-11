package tictactoe;

public class ManualPutController extends PutController {
    public ManualPutController(Game game) {
        super(game);
    }

    @Override
    protected TicTacToeCoordinate selectTarget(String targetTitle) {
        TicTacToeCoordinate target = new TicTacToeCoordinate();
        target.read(targetTitle);
        return target;
    }
}
