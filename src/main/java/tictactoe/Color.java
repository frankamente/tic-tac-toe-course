package tictactoe;

public enum Color {
    NONE('_'),
    X('x'),
    O('o');

    private final char color;

    Color(char color) {

        this.color = color;
    }

    public char getColor() {
        return color;
    }
}
