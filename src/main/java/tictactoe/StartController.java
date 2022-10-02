package tictactoe;

public class StartController extends OperationController {

    private final ColocateControllerBuilder colocateControllerBuilder;

    protected StartController(Game game, ColocateControllerBuilder colocateControllerBuilder) {
        super(game);
        this.colocateControllerBuilder = colocateControllerBuilder;
    }

    @Override
    public void control() {
        int users = new LimitedIntDialog("Cuántos usuarios?", 0, 2).read();
        colocateControllerBuilder.build(users);
        this.write();
        this.setState(State.IN_GAME);
    }
}
