package tictactoe;

public class Turn {

  private final Player[] players;
  private int value;

  public Turn(Player[] players) {
    this.value = 0;
    this.players = players;
  }


  public Player take() {
    return players[value];
  }


  public Player notTake() {
    return players[other()];
  }

  public void change() {
    value = other();
  }

    private int other() {
        return (value + 1) % TicTacToe.NUM_PLAYERS;
    }
}
