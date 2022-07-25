package tictactoe;

import java.util.Objects;

public class Token {
    private final char value;

    public Token(char value) {

        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value == token.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
