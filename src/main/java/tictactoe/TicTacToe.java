package tictactoe;

class TicTacToe {

    private final Board board;
    private final PutController putController;
    private final MoveController moveController;

    public static final int NUM_PLAYERS = 2;

    public TicTacToe() {
        board = new Board(NUM_PLAYERS);
        Turn turn = new Turn();
        putController = new PutController(turn, board);
        moveController = new MoveController(turn, board);
    }

    public void play() {
        board.write();
        do {
            if (!board.complete()) {
                putController.control();
            } else {
                moveController.control();
            }
        } while (!board.existTTT());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
