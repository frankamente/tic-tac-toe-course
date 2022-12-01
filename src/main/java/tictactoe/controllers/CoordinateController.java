package tictactoe.controllers;

import tictactoe.models.Coordinate;
import tictactoe.models.Game;

public abstract class CoordinateController extends Controller {
    protected CoordinateController(Game game) {
        super(game);
    }

    public abstract Coordinate getOrigin();

    public abstract Coordinate getTarget(String targetTitle);
}
