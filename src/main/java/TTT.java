class TTT {
    private char[][] tokens;
    public static char[] COLOR = {'x', 'o'};
    private int turn;

    private Start start;
    private Put put;
    private Move move;

    public TTT() {
        turn = 0;
        tokens = new char[3][3];
        start = new Start(tokens);
        put = new Put(tokens);
        move = new Move(tokens);
    }

    public void exec() {
        do {
            start.write();
            if (!this.complete()) {
                put.put(turn, this);
            } else {
                move.move(turn, this);
            }
            turn = (turn + 1) % 2;
        } while (!this.existTTT());
        start.write();
        this.message(turn);
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

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tokens[i][j] = '_';
            }
        }
    }

    public void message(int turn) {
        turn = (turn + 1) % 2;
        System.out.println("Victoria!!!! " + TTT.COLOR[turn] + "! " + TTT.COLOR[turn] + "! " + TTT.COLOR[turn] + "! Victoria!!!!");
    }

    public static void main(String[] args) {
        new TTT().exec();
    }
}
