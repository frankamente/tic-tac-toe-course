package tictactoe;

class TicTacToe {

    private final Game game;
    private final PutController putController;
    private final MoveController moveController;

    public TicTacToe() {
        game = new Game();
        putController = new PutController(game);
        moveController = new MoveController(game);
    }

    public void play() {
        game.getBoard().write();
        do {
            if (!game.getBoard().complete()) {
                putController.control();
            } else {
                moveController.control();
            }
        } while (!game.getBoard().existTTT());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
