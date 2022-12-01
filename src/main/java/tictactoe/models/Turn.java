package tictactoe.models;

public class Turn {

    private int value;

    public Turn() {
        this.value = 0;
    }


    public Color take() {
        return Color.values()[value];
    }


    public Color notTake() {
        return Color.values()[other()];
    }

    public void change() {
        value = other();
    }

    private int other() {
        return (value + 1) % (Color.values().length - 1);
    }
}
