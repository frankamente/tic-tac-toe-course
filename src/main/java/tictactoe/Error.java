package tictactoe;

public enum Error {
    NOT_EMPTY("Esa casilla ya está ocupada"),
    REPEATED_COORDINATED("No se puede quitar de donde se quitó"),
    NOT_PROPERTY("Esa casilla no está ocupada por ninguna de tus fichas");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
