package tictactoe;

public class Logic {

    private final Game game;
    private final StartController startController;
    private final ContinueController continueController;

    public Logic() {
        game = new Game();
        startController = new StartController(game);
        continueController = new ContinueController(game);
    }

    public OperationController getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                int player = game.getTurn().take().ordinal();
                int colocate = !game.getBoard().complete() ? 0 : 1;
                return startController.getColocateControllerArray()[player][colocate];
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
