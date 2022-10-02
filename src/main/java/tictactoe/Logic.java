package tictactoe;

public class Logic {

    private final Game game;
    private final StartController startController;
    private final ContinueController continueController;
    private final ColocateControllerBuilder colocateControllerBuilder;

    public Logic() {
        game = new Game();
        colocateControllerBuilder = new ColocateControllerBuilder(game);
        startController = new StartController(game, colocateControllerBuilder);
        continueController = new ContinueController(game);
    }

    public OperationController getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                return colocateControllerBuilder.getColocateController();
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
