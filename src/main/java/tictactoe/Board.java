package tictactoe;

public class Board {

    private final Color[][] colors;

    public static final int DIMENSION = 3;

    public Board() {

        this.colors = new Color[Board.DIMENSION][Board.DIMENSION];
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                colors[i][j] = Color.NONE;
            }
        }
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                io.write(colors[i][j].getColor() + " ");
            }
            io.writeln();
        }
    }

    public boolean complete() {
        int c = 0;
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                if (colors[i][j] != Color.NONE) {
                    c++;
                }
            }
        }
        return c == (Board.DIMENSION * TicTacToe.NUM_PLAYERS);
    }

    public void put(int row, int column, Color color) {
        colors[row][column] = color;
    }

    public boolean empty(int row, int token) {
        return colors[row][token] == Color.NONE;
    }

    public boolean full(int row, int column, Color color) {
        return colors[row][column] == color;
    }

    public boolean existTTT() {
        return this.existTTT(Color.X) || this.existTTT(Color.O);
    }

    private boolean existTTT(Color color) {
        if (colors[1][1] == color) {
            if (colors[0][0] == color) {
                return colors[2][2] == color;
            }
            if (colors[0][2] == color) {
                return colors[2][0] == color;
            }
            if (colors[0][1] == color) {
                return colors[2][1] == color;
            }
            if (colors[1][0] == color) {
                return colors[1][2] == color;
            }
            return false;
        }
        if (colors[0][0] == color) {
            if (colors[0][1] == color) {
                return colors[0][2] == color;
            }
            if (colors[1][0] == color) {
                return colors[2][0] == color;
            }
            return false;
        }
        if (colors[2][2] == color) {
            if (colors[1][2] == color) {
                return colors[0][2] == color;
            }
            if (colors[2][1] == color) {
                return colors[2][0] == color;
            }
            return false;
        }
        return false;
    }

}
