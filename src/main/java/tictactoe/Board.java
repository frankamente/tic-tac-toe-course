package tictactoe;

public class Board {

    private final Token[][] tokens;
    public static char[] COLOR = {'x', 'o'};

    public Board() {

        this.tokens = new Token[3][3];
        this.start();
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tokens[i][j] = new Token('_');
            }
        }
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                io.write(tokens[i][j].getValue() + " ");
            }
            io.writeln();
        }
    }

    public boolean complete() {
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!tokens[i][j].equals(new Token('_'))) {
                    c++;
                }
            }
        }
        return c == 6;
    }

    public void put(int row, int column, Token token) {
        tokens[row][column] = token;
    }

    public boolean empty(int r, int c) {
        return tokens[r][c].equals(new Token('_'));
    }

    public boolean full(int row, int column, Token token) {
        return tokens[row][column].equals(token);
    }

    public boolean existTTT() {
        return this.existTTT(new Token('x')) || this.existTTT(new Token('o'));
    }

    private boolean existTTT(Token token) {
        if (tokens[1][1].equals(token)) {
            if (tokens[0][0].equals(token)) {
                return tokens[2][2].equals(token);
            }
            if (tokens[0][2].equals(token)) {
                return tokens[2][0].equals(token);
            }
            if (tokens[0][1].equals(token)) {
                return tokens[2][1].equals(token);
            }
            if (tokens[1][0].equals(token)) {
                return tokens[1][2].equals(token);
            }
            return false;
        }
        if (tokens[0][0].equals(token)) {
            if (tokens[0][1].equals(token)) {
                return tokens[0][2].equals(token);
            }
            if (tokens[1][0].equals(token)) {
                return tokens[2][0].equals(token);
            }
            return false;
        }
        if (tokens[2][2].equals(token)) {
            if (tokens[1][2].equals(token)) {
                return tokens[0][2].equals(token);
            }
            if (tokens[2][1].equals(token)) {
                return tokens[2][0].equals(token);
            }
            return false;
        }
        return false;
    }

}
