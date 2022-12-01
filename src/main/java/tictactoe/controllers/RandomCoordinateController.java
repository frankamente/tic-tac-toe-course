package tictactoe.controllers;

import tictactoe.models.Coordinate;
import tictactoe.models.Game;
import tictactoe.utils.IO;

public class RandomCoordinateController extends CoordinateController {
    public RandomCoordinateController(Game game) {
        super(game);
    }

    private Coordinate origin;


    @Override
    public Coordinate getOrigin() {
        origin = new Coordinate();
        boolean ok;
        do {
            origin.random();
            ok = this.full(origin, this.take());
        } while (!ok);
        new IO().writeln("La máquina quita de " + origin);
        new IO().readString("Enter para continuar!");
        Coordinate result = origin;
        origin = null;
        return result;
    }

    @Override
    public Coordinate getTarget(String targetTitle) {
        Coordinate target = new Coordinate();
        boolean ok;
        do {
            target.random();
            ok = this.empty(target);
            if (ok) {
                if (origin != null) {
                    ok = !origin.equals(target);
                }
            }
        } while (!ok);
        new IO().writeln("La máquina pone en " + target);
        new IO().readString("Enter para continuar!");
        return target;
    }
}
