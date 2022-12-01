package tictactoe.controllers;

import tictactoe.models.Coordinate;
import tictactoe.models.Game;
import tictactoe.utils.IO;

public class MoveController extends ColocateController {

    private Coordinate origin;

    public MoveController(Game game, CoordinateController coordinateController) {
        super(game, "Mueve", coordinateController);
        origin = new Coordinate();
    }

    @Override
    protected void colocate() {
        this.remove();
        this.put("A");
    }

    private void remove() {
        Error error;
        do {
            origin = this.getCoordinateController().getOrigin();
            error = this.validateOrigin();
            if (error != null) {
                new IO().writeln(error.toString());
            }
        } while (error != null);
        this.remove(origin, this.take());
    }

    private Error validateOrigin() {
        if (!this.full(origin, this.take())) {
            return Error.NOT_PROPERTY;
        }
        return null;
    }

    @Override
    protected Error validateTarget() {
        Error error = super.validateTarget();
        if (error != null) {
            return error;
        }
        if (origin.equals(this.getTarget())) {
            return Error.REPEATED_COORDINATE;
        }
        return null;
    }
}
