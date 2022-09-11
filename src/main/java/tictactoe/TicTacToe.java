package tictactoe;

class TicTacToe {

    private final Logic logic;

    public TicTacToe() {
        logic = new Logic();
    }

    public void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
