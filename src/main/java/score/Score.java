package score;

import player.Player;

public class Score {

    private final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private final String BALL="볼";
    private final String STRIKE="스트라이크";
    private final String NOTHING="낫싱";

    private int ballCount = 0;
    private int strikeCount = 0;

    public Score() {
    }

    public void increaseBall() {
        ballCount++;
    }

    public void increaseStrike() {
        strikeCount++;
    }

    public String printScore() {
        StringBuilder sb = new StringBuilder();

        if (ballCount > 0) {
            sb.append(ballCount).append(BALL);
        }

        if (ballCount > 0 && strikeCount > 0) {
            sb.append(" ");
        }

        if (strikeCount > 0) {
            sb.append(strikeCount).append(STRIKE);
        }

        if (ballCount == 0 && strikeCount == 0) {
            sb.append(NOTHING);
        }

        sb.append("\n");

        if (strikeCount == Player.SIZE) {
            sb.append(GAME_END);
        }

        return sb.toString();
    }

    public boolean isCorrect() {
        if (strikeCount == Player.SIZE) {
            return true;
        }

        return false;
    }
}
