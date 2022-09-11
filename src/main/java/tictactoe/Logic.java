package tictactoe;

public class Logic {

    private final Game game;
    private final StartController startController;
    private final PutController putController;
    private final MoveController moveController;
    private final ContinueController continueController;

    public Logic() {
        game = new Game();
        startController = new StartController(game);
        putController = new PutController(game);
        moveController = new MoveController(game);
        continueController = new ContinueController(game);
    }

    public Controller getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                if (!game.getBoard().complete()) {
                    return putController;
                } else {
                    return moveController;
                }
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
