package tictactoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private final Map<Integer, Set<TicTacToeCoordinate>> ticTacToeCoordinates;
    private final int numPlayers;

    public Board(int numPlayers) {
        this.numPlayers = numPlayers;

        this.ticTacToeCoordinates = new HashMap<>();
        this.clear();
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
        return !this.full(ticTacToeCoordinate, Color.X) && !this.full(ticTacToeCoordinate, Color.O);
    }

    public boolean full(TicTacToeCoordinate ticTacToeCoordinate, Color color) {
        return ticTacToeCoordinates.get(color.ordinal()).contains(ticTacToeCoordinate);
    }

    public boolean existTTT(Color color) {
        Set<TicTacToeCoordinate> coordinateSet = ticTacToeCoordinates.get(color.ordinal());
        if (coordinateSet.size() != TicTacToeCoordinate.DIMENSION) {
            return false;
        }
        TicTacToeCoordinate[] coordinateArray = coordinateSet
                .toArray(new TicTacToeCoordinate[0]);
        Direction direction = coordinateArray[0].direction(coordinateArray[1]);
        if (direction == Direction.NON_EXISTENT) {
            return false;
        }
        for (int i = 1; i < TicTacToeCoordinate.DIMENSION - 1; i++) {
            if (coordinateArray[i].direction(coordinateArray[i + 1]) != direction) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < numPlayers; i++) {
            ticTacToeCoordinates.put(i, new HashSet<>());
        }
    }
}
