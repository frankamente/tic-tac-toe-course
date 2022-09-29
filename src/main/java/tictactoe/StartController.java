package tictactoe;

public class StartController extends OperationController {

    private ColocateController[][] colocateControllerArray;

    protected StartController(Game game) {
        super(game);
        colocateControllerArray = new ColocateController[2][2];
    }

    @Override
    public void control() {
        int users = new LimitedIntDialog("Cuántos usuarios?", 0, 2).read();
        colocateControllerArray = new ColocateController[2][2];
        for (int i = 0; i < 2; i++) {
            if (i < users) {
                final UserCoordinateController coordinateController = new UserCoordinateController(this.getGame());
                colocateControllerArray[i][0] = new PutController(this.getGame(), coordinateController);
                colocateControllerArray[i][1] = new MoveController(this.getGame(), coordinateController);
            } else {
                final RandomCoordinateController coordinateController = new RandomCoordinateController(this.getGame());
                colocateControllerArray[i][0] = new PutController(this.getGame(), coordinateController);
                colocateControllerArray[i][1] = new MoveController(this.getGame(), coordinateController);
            }
        }
        this.getBoard().write();
        this.setState(State.IN_GAME);
    }

    public ColocateController[][] getColocateControllerArray() {
        return colocateControllerArray;
    }
}
