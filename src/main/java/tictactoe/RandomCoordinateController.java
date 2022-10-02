package tictactoe;

public class RandomCoordinateController extends CoordinateController {
    public RandomCoordinateController(Game game) {
        super(game);
    }

    private TicTacToeCoordinate origin;


    @Override
    public TicTacToeCoordinate getOrigin() {
        origin = new TicTacToeCoordinate();
        boolean ok;
        do {
            origin.random();
            ok = this.full(origin, this.take());
        } while (!ok);
        new IO().writeln("La máquina quita de " + origin);
        new IO().readString("Enter para continuar!");
        TicTacToeCoordinate result = origin;
        origin = null;
        return result;
    }

    @Override
    public TicTacToeCoordinate getTarget(String targetTitle) {
        TicTacToeCoordinate target = new TicTacToeCoordinate();
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
