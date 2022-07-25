class TicTacToe {
    private int turn;
    private final Board board;

    public TicTacToe() {
        board = new Board();
        turn = 0;
    }

    public void exec() {
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
        this.message(turn);
    }

    public void message(int turn) {
        IO io = new IO();
        turn = (turn + 1) % 2;
        io.writeln("Victoria!!!! " + Board.COLOR[turn] + "! " + Board.COLOR[turn] + "! " + Board.COLOR[turn] + "! Victoria!!!!");
    }

    public static void main(String[] args) {
        new TicTacToe().exec();
    }
}
