package baseball;

import game.Game;

public class Application {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.startGame();
    }
}
