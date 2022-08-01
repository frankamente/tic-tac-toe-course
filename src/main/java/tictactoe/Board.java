package tictactoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private final Map<Integer, Set<Coordinate>> coordinates;

    public Board(int numPlayers) {

        this.coordinates = new HashMap<>();
        for (int i = 0; i < numPlayers; i++) {
            coordinates.put(i, new HashSet<>());
        }
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
        for (Integer player : coordinates.keySet()) {
            if (coordinates.get(player).contains(coordinate)) {
                return Color.values()[player];
            }
        }
        return Color.NONE;
    }

    public boolean complete() {
        int numberOfTokens = 0;
        for (Integer player : coordinates.keySet()) {
            numberOfTokens += coordinates.get(player).size();
        }
        return numberOfTokens == (Coordinate.DIMENSION * coordinates.keySet().size());
    }

    public void put(Coordinate coordinate, Color color) {
        coordinates.get(color.ordinal()).add(coordinate);
    }

    public void remove(Coordinate coordinate) {
        this.put(coordinate, Color.NONE);
    }

    public boolean empty(Coordinate coordinate) {
        return this.full(coordinate, Color.NONE);
    }

    public boolean full(Coordinate coordinate, Color color) {
        return coordinates.get(color.ordinal()).contains(coordinate);
    }

    public boolean existTTT() {
        return this.existTTT(Color.X) || this.existTTT(Color.O);
    }

    private boolean existTTT(Color color) {
        Set<Coordinate> coordinateSet = coordinates.get(color.ordinal());

        if (coordinateSet.size() != Coordinate.DIMENSION) {
            return false;
        }

        Coordinate[] coordinateArray = coordinateSet.toArray(new Coordinate[0]);
        Direction direction = coordinateArray[0].direction(coordinateArray[1]);

        for (int i = 1; i < coordinateSet.size() - 1; i++) {
            Direction newDirection = coordinateArray[i].direction(coordinateArray[i + 1]);
            if (!direction.equals(newDirection)) {
                return false;
            }
        }

        return true;
    }
}
