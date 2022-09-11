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

    public Board getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
