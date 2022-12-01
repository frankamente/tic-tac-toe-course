package tictactoe.controllers;

import tictactoe.models.Game;

public class PutController extends ColocateController {

    public PutController(Game game, CoordinateController coordinateController) {
        super(game, "Pone", coordinateController);
    }

    @Override
    protected void colocate() {
        this.put("En");
    }
}
