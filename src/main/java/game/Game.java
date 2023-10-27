package game;

import static util.Judge.calculateScore;

import player.Computer;
import player.User;
import score.Score;
import view.GameView;
import view.UserView;

public class Game {
    private static Game INSTANCE;
    private GameView gameView;
    private UserView userView;

    private Game() {
        gameView = GameView.getInstance();
        userView = UserView.getInstance();
    }

    public static Game getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }

        return INSTANCE;
    }

    public void startGame() {
        User user = new User();
        Computer computer = new Computer();

        gameView.gameStart();
        computer.setNumbers();

        this.turn(user, computer);
    }

    private void turn(User user, Computer computer) {
        boolean start = true;
        while (start) {
            userView.enterNumber();
            user.setNumbers();

            Score score = calculateScore(user, computer);
            gameView.printScore(score);

            if (continueGame(score)) {
                continue;
            }

            userView.enterRestart();
            start = user.chooseGameEnd();

            if (start) {
                continue;
            }

            restartGame(computer);
        }
    }

    private boolean continueGame(Score score) {
        return !score.isCorrect();
    }

    private void restartGame(Computer computer) {
        computer.setNumbers();
    }
}
