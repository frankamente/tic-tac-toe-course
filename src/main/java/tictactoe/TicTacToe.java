package tictactoe;

class TicTacToe {

    private final Board board;
    private final PutController putController;
    private final MoveController moveController;

    private Turn turn;

    public static final int NUM_PLAYERS = 2;

    public TicTacToe() {
        board = new Board(NUM_PLAYERS);
        turn = new Turn();
        putController = new PutController(turn, board);
        moveController = new MoveController(turn, board);
    }

    public void play() {
        board.write();
        do {
            if (!board.complete()) {
                putController.put();
            } else {
                moveController.move();
            }
        } while (!board.existTTT());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
