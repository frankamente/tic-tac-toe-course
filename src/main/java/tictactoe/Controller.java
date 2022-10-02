package tictactoe;

public abstract class Controller {

    private final Game game;

    protected Controller(Game game) {
        this.game = game;
    }

    protected void setState(State state) {
        game.setState(state);
    }

    protected void write() {
        game.write();
    }

    protected Color take() {
        return game.take();
    }

    protected boolean existTTT() {
        return game.existTTT();
    }

    protected boolean empty(TicTacToeCoordinate ticTacToeCoordinate) {
        return game.empty(ticTacToeCoordinate);
    }

    protected void change() {
        game.change();
    }

    protected void put(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        game.put(ticTacToeCoordinate, color);
    }

    protected void clear() {
        game.clear();
    }

    protected void remove(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        game.remove(ticTacToeCoordinate, color);
    }

    protected boolean full(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        return game.full(ticTacToeCoordinate, color);
    }
}
