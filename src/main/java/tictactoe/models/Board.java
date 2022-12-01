package tictactoe.models;

import tictactoe.utils.Direction;
import tictactoe.utils.IO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private final Map<Integer, Set<Coordinate>> ticTacToeCoordinates;
    private final int numPlayers;

    public Board(int numPlayers) {
        this.numPlayers = numPlayers;

        this.ticTacToeCoordinates = new HashMap<>();
        this.clear();
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                io.write(this.getColor(new Coordinate(i, j)).getValue() + " ");
            }
            io.writeln();
        }
    }

    private Color getColor(Coordinate coordinate) {
        for (Integer player : ticTacToeCoordinates.keySet()) {
            if (ticTacToeCoordinates.get(player).contains(coordinate)) {
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
        return numberOfTokens == (Coordinate.DIMENSION * ticTacToeCoordinates.keySet().size());
    }

    public void put(Coordinate coordinate, Color color) {
        ticTacToeCoordinates.get(color.ordinal()).add(coordinate);
    }

    public void remove(Coordinate coordinate, Color color) {
        ticTacToeCoordinates.get(color.ordinal()).remove(coordinate);
    }

    public boolean empty(Coordinate coordinate) {
        return !this.full(coordinate, Color.X) && !this.full(coordinate, Color.O);
    }

    public boolean full(Coordinate coordinate, Color color) {
        return ticTacToeCoordinates.get(color.ordinal()).contains(coordinate);
    }

    public boolean existTTT(Color color) {
        Set<Coordinate> coordinateSet = ticTacToeCoordinates.get(color.ordinal());
        if (coordinateSet.size() != Coordinate.DIMENSION) {
            return false;
        }
        Coordinate[] coordinateArray = coordinateSet
                .toArray(new Coordinate[0]);
        Direction direction = coordinateArray[0].direction(coordinateArray[1]);
        if (direction == Direction.NON_EXISTENT) {
            return false;
        }
        for (int i = 1; i < Coordinate.DIMENSION - 1; i++) {
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
