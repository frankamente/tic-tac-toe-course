package tictactoe.controllers;

import tictactoe.models.Color;
import tictactoe.models.Coordinate;
import tictactoe.models.Game;
import tictactoe.models.State;

public abstract class Controller {

    private final Game game;

    protected Controller(Game game) {
        this.game = game;
    }

    protected void setState(State state) {
        game.setState(state);
    }

    protected void write() {
        game.write();
    }

    protected Color take() {
        return game.take();
    }

    protected boolean existTTT() {
        return game.existTTT();
    }

    protected boolean empty(Coordinate coordinate) {
        return game.empty(coordinate);
    }

    protected void change() {
        game.change();
    }

    protected void put(Coordinate coordinate, Color color) {
        game.put(coordinate, color);
    }

    protected void clear() {
        game.clear();
    }

    protected void remove(Coordinate coordinate, Color color) {
        game.remove(coordinate, color);
    }

    protected boolean full(Coordinate coordinate, Color color) {
        return game.full(coordinate, color);
    }
}
