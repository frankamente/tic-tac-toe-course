class TicTacToe {

    private final Board board;

    private int turn;

    public TicTacToe() {
        board = new Board();
        turn = 0;
    }

    public void play() {
        do {
            board.write();
            if (!board.complete()) {
                board.put(turn);
            } else {
                board.move(turn);
            }
            turn = (turn + 1) % 2;
        } while (!board.existTTT());
        board.write();
        board.win(turn);
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
