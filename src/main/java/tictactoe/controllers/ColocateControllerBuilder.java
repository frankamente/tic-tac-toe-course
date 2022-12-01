package tictactoe.controllers;

import tictactoe.models.Game;

public class ColocateControllerBuilder {

    private final ColocateController[][] colocateControllerArray;
    private final Game game;

    public ColocateControllerBuilder(Game game) {
        this.game = game;
        this.colocateControllerArray = new ColocateController[Game.NUM_PLAYERS][Game.NUM_PLAYERS];
    }

    public void build(int users) {
        CoordinateController[][] coordinateControllers = new CoordinateController[2][2];
        for (int i = 0; i < Game.NUM_PLAYERS; i++) {
            for (int j = 0; j < 2; j++) {
                if (i < users) {
                    coordinateControllers[i][j] = new UserCoordinateController(game);
                } else {
                    coordinateControllers[i][j] = new RandomCoordinateController(game);
                }
            }
        }

        for (int i = 0; i < Game.NUM_PLAYERS; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    colocateControllerArray[i][j] = new PutController(game, coordinateControllers[i][j]);
                } else {
                    colocateControllerArray[i][j] = new MoveController(game, coordinateControllers[i][j]);
                }
            }
        }
    }

    public ColocateController getColocateController() {
        int player = game.take().ordinal();
        if (!game.complete()) {
            return colocateControllerArray[player][0];
        }
        return colocateControllerArray[player][1];
    }
}
