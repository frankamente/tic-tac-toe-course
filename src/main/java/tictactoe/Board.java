package tictactoe;

public class Board {

    private final char[][] tokens;
    public static char[] COLOR = {'x', 'o'};

    public Board() {

        this.tokens = new char[3][3];
        this.start();
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tokens[i][j] = '_';
            }
        }
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                io.write(tokens[i][j] + " ");
            }
            io.writeln();
        }
    }

    public boolean complete() {
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tokens[i][j] != '_') {
                    c++;
                }
            }
        }
        return c == 6;
    }

    public void put(int row, int column, char token) {
        tokens[row][column] = token;
    }

    public boolean empty(int row, int token) {
        return tokens[row][token] == '_';
    }

    public boolean full(int row, int column, char token) {
        return tokens[row][column] == token;
    }

    public boolean existTTT() {
        return this.existTTT('x') || this.existTTT('o');
    }

    private boolean existTTT(char token) {
        if (tokens[1][1] == token) {
            if (tokens[0][0] == token) {
                return tokens[2][2] == token;
            }
            if (tokens[0][2] == token) {
                return tokens[2][0] == token;
            }
            if (tokens[0][1] == token) {
                return tokens[2][1] == token;
            }
            if (tokens[1][0] == token) {
                return tokens[1][2] == token;
            }
            return false;
        }
        if (tokens[0][0] == token) {
            if (tokens[0][1] == token) {
                return tokens[0][2] == token;
            }
            if (tokens[1][0] == token) {
                return tokens[2][0] == token;
            }
            return false;
        }
        if (tokens[2][2] == token) {
            if (tokens[1][2] == token) {
                return tokens[0][2] == token;
            }
            if (tokens[2][1] == token) {
                return tokens[2][0] == token;
            }
            return false;
        }
        return false;
    }

}
