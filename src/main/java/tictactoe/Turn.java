package tictactoe;

public class Turn {

    private int value;

    public Turn() {
        value = 0;
    }


    public int take() {
        return value;
    }


    public int notTake() {
        return (value + 1) % TicTacToe.NUM_PLAYERS;
    }

    public void change() {
        value = notTake();
    }
}
