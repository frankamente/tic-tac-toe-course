package tictactoe.controllers;

import tictactoe.models.Coordinate;
import tictactoe.models.Game;
import tictactoe.models.State;
import tictactoe.utils.IO;

public abstract class ColocateController extends OperationController {

    private final String actionTitle;

    private Coordinate target;

    private final CoordinateController coordinateController;

    public ColocateController(Game game, String actionTitle, CoordinateController coordinateController) {
        super(game);
        this.actionTitle = actionTitle;
        this.coordinateController = coordinateController;
        this.target = new Coordinate();
    }

    public void control() {
        IO io = new IO();
        io.writeln(actionTitle + " el jugador " + this.take().getValue());
        this.colocate();
        this.write();
        if (this.existTTT()) {
            io.writeln("Victoria!!!! Gana el jugador: " + this.take().getValue());
            this.setState(State.FINAL);
        } else {
            this.change();
        }
    }

    protected abstract void colocate();

    protected void put(String targetTitle) {
        Error error;
        do {
            target = coordinateController.getTarget(targetTitle);
            error = this.validateTarget();
            if (error != null) {
                new IO().writeln("" + error);
            }
        } while (error != null);
        this.put(target, this.take());
    }

    protected Error validateTarget() {
        if (!this.empty(target)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }

    public Coordinate getTarget() {
        return target;
    }

    public CoordinateController getCoordinateController() {
        return coordinateController;
    }
}
