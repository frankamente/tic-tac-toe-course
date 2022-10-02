package tictactoe;

public class Game {

    private final Board board;
    private final Turn turn;
    public static final int NUM_PLAYERS = 2;
    private State state;

    public Game() {
        state = State.INITIAL;
        board = new Board(NUM_PLAYERS);
        turn = new Turn();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void write() {
        board.write();
    }

    public Color take() {
        return turn.take();
    }

    public boolean empty(TicTacToeCoordinate ticTacToeCoordinate) {
        return board.empty(ticTacToeCoordinate);
    }

    public boolean existTTT() {
        return board.existTTT(take());
    }

    public void change() {
        turn.change();
    }

    public void put(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        board.put(ticTacToeCoordinate, color);
    }

    public boolean complete() {
        return board.complete();
    }

    public void clear() {
        board.clear();
    }

    public void remove(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        board.remove(ticTacToeCoordinate, color);
    }

    public boolean full(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        return board.full(ticTacToeCoordinate, color);
    }
}
