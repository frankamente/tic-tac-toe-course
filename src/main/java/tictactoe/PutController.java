package tictactoe;

public class PutController extends ColocateController {

    public PutController(Game game) {

        super(game);
    }

    @Override
    public void control() {
        this.put("Pone", "En");
    }

    @Override
    protected void colocate(String targetTitle) {
        this.put(targetTitle);
    }
}
