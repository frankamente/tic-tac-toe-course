package tictactoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private final Map<Integer, Set<TicTacToeCoordinate>> ticTacToeCoordinates;

    public Board(int numPlayers) {

        this.ticTacToeCoordinates = new HashMap<>();
        for (int i = 0; i < numPlayers; i++) {
            ticTacToeCoordinates.put(i, new HashSet<>());
        }
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < TicTacToeCoordinate.DIMENSION; i++) {
            for (int j = 0; j < TicTacToeCoordinate.DIMENSION; j++) {
                io.write(this.getColor(new TicTacToeCoordinate(i, j)).getValue() + " ");
            }
            io.writeln();
        }
    }

    private Color getColor(TicTacToeCoordinate ticTacToeCoordinate) {
        for (Integer player : ticTacToeCoordinates.keySet()) {
            if (ticTacToeCoordinates.get(player).contains(ticTacToeCoordinate)) {
                return Color.values()[player];
            }
        }
        return Color.NONE;
    }

    public boolean complete() {
        int numberOfTokens = 0;
        for (Integer player : ticTacToeCoordinates.keySet()) {
            numberOfTokens += ticTacToeCoordinates.get(player).size();
        }
        return numberOfTokens == (TicTacToeCoordinate.DIMENSION * ticTacToeCoordinates.keySet().size());
    }

    public void put(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        ticTacToeCoordinates.get(color.ordinal()).add(ticTacToeCoordinate);
    }

    public void remove(TicTacToeCoordinate ticTacToeCoordinate) {
        this.put(ticTacToeCoordinate, Color.NONE);
    }

    public boolean empty(TicTacToeCoordinate ticTacToeCoordinate) {
        return this.full(ticTacToeCoordinate, Color.NONE);
    }

    public boolean full(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        return ticTacToeCoordinates.get(color.ordinal()).contains(ticTacToeCoordinate);
    }

    public boolean existTTT() {
        return this.existTTT(Color.X) || this.existTTT(Color.O);
    }

    private boolean existTTT(Color color) {
        Set<TicTacToeCoordinate> ticTacToeCoordinateSet = ticTacToeCoordinates.get(color.ordinal());

        if (ticTacToeCoordinateSet.size() != TicTacToeCoordinate.DIMENSION) {
            return false;
        }

        TicTacToeCoordinate[] ticTacToeCoordinateArray = ticTacToeCoordinateSet.toArray(new TicTacToeCoordinate[0]);
        Direction direction = ticTacToeCoordinateArray[0].direction(ticTacToeCoordinateArray[1]);

        for (int i = 1; i < ticTacToeCoordinateSet.size() - 1; i++) {
            Direction newDirection = ticTacToeCoordinateArray[i].direction(ticTacToeCoordinateArray[i + 1]);
            if (!direction.equals(newDirection)) {
                return false;
            }
        }

        return true;
    }
}
