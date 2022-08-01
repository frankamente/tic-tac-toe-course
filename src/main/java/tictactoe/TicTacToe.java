package tictactoe;

class TicTacToe {

    private final Board board;

    private Turn turn;

    public static final int NUM_PLAYERS = 2;

    public TicTacToe() {
        board = new Board();
        Player[] players = new Player[TicTacToe.NUM_PLAYERS];
        for (int i = 0; i < TicTacToe.NUM_PLAYERS; i++) {
            players[i] = new Player(i, board);
        }
        turn = new Turn(players);
    }

    public void play() {
        do {
            board.write();
            if (!board.complete()) {
                turn.take().put();
            } else {
                turn.take().move();
            }
            turn.change();
        } while (!board.existTTT());
        board.write();
        turn.notTake().win();
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
