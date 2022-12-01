package tictactoe.controllers;

import tictactoe.models.Coordinate;
import tictactoe.models.Game;

public class UserCoordinateController extends CoordinateController {
    public UserCoordinateController(Game game) {
        super(game);
    }

    @Override
    public Coordinate getOrigin() {
        Coordinate origin = new Coordinate();
        origin.read("De");
        return origin;
    }

    @Override
    public Coordinate getTarget(String targetTitle) {
        Coordinate target = new Coordinate();
        target.read(targetTitle);
        return target;
    }
}
