class TicTacToe {
    private char[][] tokens;
    public static char[] COLOR = {'x', 'o'};
    private int turn;

    public TicTacToe() {
        turn = 0;
        tokens = new char[3][3];
    }

    public void exec() {
        this.start();
        do {
            this.write();
            if (!this.complete()) {
                this.put(turn, this);
            } else {
                this.move(turn, this);
            }
            turn = (turn + 1) % 2;
        } while (!this.existTTT());
        this.write();
        this.message(turn);
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tokens[i][j] = '_';
            }
        }
    }

    private void write() {
        IO io = new IO();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                io.write(tokens[i][j] + " ");
            }
            io.writeln();
        }
    }

    private void put(int turn, TicTacToe ticTacToe) {
        IO io = new IO();
        io.writeln("Pone el jugador " + TicTacToe.COLOR[turn]);
        int row = 0;
        int column = 0;
        boolean ok;
        do {
            io.writeln("En qué casilla?");
            do {
                ok = false;
                do {
                    try {
                        row = io.readInt("Fila? [1,3]: ");
                        ok = true;
                    } catch (Exception ex) {
                        io.writeln("ERROR DE FORMATO! "
                                + "Introduzca un valor con formato entero.");
                    }
                } while (!ok);
            } while (row < 1 || 3 < row);
            do {
                ok = false;
                do {
                    try {
                        column = io.readInt("Columna? [1,3]: ");
                        ok = true;
                    } catch (Exception ex) {
                        io.writeln("ERROR DE FORMATO! "
                                + "Introduzca un valor con formato entero.");
                    }
                } while (!ok);
            } while (column < 1 || 3 < column);
            ok = ticTacToe.empty(row - 1, column - 1);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        tokens[row - 1][column - 1] = TicTacToe.COLOR[turn];
    }

    private void move(int turn, TicTacToe ticTacToe) {
        IO io = new IO();
        io.writeln("Mueve el jugador " + TicTacToe.COLOR[turn]);
        int originRow = 0;
        int originColumn = 0;
        int targetRow = 0;
        int targetColumn = 0;
        boolean ok;
        do {
            io.writeln("De qué casilla?");
            do {
                ok = false;
                do {
                    try {
                        originRow = io.readInt("Fila? [1,3]: ");
                        ok = true;
                    } catch (Exception ex) {
                        io.writeln("ERROR DE FORMATO! "
                                + "Introduzca un valor con formato entero.");
                    }
                } while (!ok);
            } while (originRow < 1 || 3 < originRow);
            do {
                ok = false;
                do {
                    try {
                        originColumn = io.readInt("Columna? [1,3]: ");
                        ok = true;
                    } catch (Exception ex) {
                        io.writeln("ERROR DE FORMATO! "
                                + "Introduzca un valor con formato entero.");
                    }
                } while (!ok);
            } while (1 <= originColumn && originColumn <= 3);
            ok = ticTacToe.full(originRow - 1, originColumn - 1, TicTacToe.COLOR[turn]);
            if (!ok) {
                io.writeln("Esa casilla no está ocupada por ninguna de tus fichas");
            }
        } while (!ok);
        do {
            io.writeln("A qué casilla?");
            do {
                ok = false;
                do {
                    try {
                        targetRow = io.readInt("Fila? [1,3]: ");
                        ok = true;
                    } catch (Exception ex) {
                        io.writeln("ERROR DE FORMATO! "
                                + "Introduzca un valor con formato entero.");
                    }
                } while (!ok);
            } while (targetRow < 1 || 3 < targetRow);
            do {
                ok = false;
                do {
                    try {
                        targetColumn = io.readInt("Columna? [1,3]: ");
                        ok = true;
                    } catch (Exception ex) {
                        io.writeln("ERROR DE FORMATO! "
                                + "Introduzca un valor con formato entero.");
                    }
                } while (!ok);
            } while (targetColumn < 1 || 3 < targetColumn);
            ok = ticTacToe.empty(targetRow - 1, targetColumn - 1);
            if (!ok) {
                io.writeln("Esa casilla no está vacía");
            }
        } while (!ok);
        tokens[originRow - 1][originColumn - 1] = '_';
        tokens[targetRow - 1][targetColumn - 1] = TicTacToe.COLOR[turn];
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

    public boolean existTTT() {
        return this.existTTT('x') || this.existTTT('o');
    }

    public boolean existTTT(char token) {
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

    public boolean empty(int r, int c) {
        return tokens[r][c] == '_';
    }

    public boolean full(int r, int c, char t) {
        return tokens[r][c] == t;
    }

    public void message(int turn) {
        IO io = new IO();
        turn = (turn + 1) % 2;
        io.writeln("Victoria!!!! " + TicTacToe.COLOR[turn] + "! " + TicTacToe.COLOR[turn] + "! " + TicTacToe.COLOR[turn] + "! Victoria!!!!");
    }

    public static void main(String[] args) {
        new TicTacToe().exec();
    }
}
