package tictactoe.models;

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

    public boolean empty(Coordinate coordinate) {
        return board.empty(coordinate);
    }

    public boolean existTTT() {
        return board.existTTT(take());
    }

    public void change() {
        turn.change();
    }

    public void put(Coordinate coordinate, Color color) {
        board.put(coordinate, color);
    }

    public boolean complete() {
        return board.complete();
    }

    public void clear() {
        board.clear();
    }

    public void remove(Coordinate coordinate, Color color) {
        board.remove(coordinate, color);
    }

    public boolean full(Coordinate coordinate, Color color) {
        return board.full(coordinate, color);
    }
}
