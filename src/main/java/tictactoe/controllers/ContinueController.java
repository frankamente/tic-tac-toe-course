package tictactoe.controllers;

import tictactoe.utils.YesNoDialog;
import tictactoe.models.Game;
import tictactoe.models.State;

public class ContinueController extends OperationController {
    protected ContinueController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        char answer = new YesNoDialog().read();
        if (answer == 's' || answer == 'S') {
            this.clear();
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }
}
