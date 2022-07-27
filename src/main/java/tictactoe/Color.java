package tictactoe;

public enum Color {
    X('x'),
    O('o'),
    NONE('_');

    private final char value;

    Color(char value) {

        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
