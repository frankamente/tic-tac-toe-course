public class Board {

    private final char[][] tokens;
    public static char[] COLOR = {'x', 'o'};

    public Board() {

        this.tokens = new char[3][3];
        this.start();
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

    public void start() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tokens[i][j] = '_';
            }
        }
    }

    public void put(int turn) {
        IO io = new IO();
        io.writeln("Pone el jugador " + Board.COLOR[turn]);
        int row = 0;
        int column = 0;
        boolean ok;
        do {
            io.writeln("En qué casilla?");
            do {
                row = io.readInt("Fila? [1,3]: ");
            } while (row < 1 || 3 < row);
            do {
                column = io.readInt("Columna? [1,3]: ");
            } while (column < 1 || 3 < column);
            ok = this.empty(row - 1, column - 1);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        tokens[row - 1][column - 1] = Board.COLOR[turn];
    }

    public void move(int turn) {
        IO io = new IO();
        io.writeln("Mueve el jugador " + Board.COLOR[turn]);
        int originRow = 0;
        int originColumn = 0;
        int targetRow = 0;
        int targetColumn = 0;
        boolean ok;
        do {
            io.writeln("De qué casilla?");
            do {
                originRow = io.readInt("Fila? [1,3]: ");
            } while (originRow < 1 || 3 < originRow);
            do {
                originColumn = io.readInt("Columna? [1,3]: ");
            } while (1 <= originColumn && originColumn <= 3);
            ok = this.full(originRow - 1, originColumn - 1, Board.COLOR[turn]);
            if (!ok) {
                io.writeln("Esa casilla no está ocupada por ninguna de tus fichas");
            }
        } while (!ok);
        do {
            io.writeln("A qué casilla?");
            do {
                targetRow = io.readInt("Fila? [1,3]: ");
            } while (targetRow < 1 || 3 < targetRow);
            do {
                targetColumn = io.readInt("Columna? [1,3]: ");
            } while (targetColumn < 1 || 3 < targetColumn);
            ok = this.empty(targetRow - 1, targetColumn - 1);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        tokens[originRow - 1][originColumn - 1] = '_';
        tokens[targetRow - 1][targetColumn - 1] = Board.COLOR[turn];
    }

    private boolean empty(int r, int c) {
        return tokens[r][c] == '_';
    }

    private boolean full(int r, int c, char t) {
        return tokens[r][c] == t;
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
