package tictactoe;

public abstract class Controller {

    private final Game game;

    protected Controller(Game game) {
        this.game = game;
    }

    public abstract void control();

    protected State getState() {
        return game.getState();
    }
    protected void setState(State state) {
        game.setState(state);
    }

    public Turn getTurn() {
        return game.getTurn();
    }

    public Board getBoard() {
        return game.getBoard();
    }
}
