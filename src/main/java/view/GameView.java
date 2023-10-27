package view;

import score.Score;

public class GameView {
    private static GameView INSTANCE;

    private final String START_MESSAGE="숫자 야구 게임을 시작합니다.";

    private GameView(){}

    public static GameView getInstance(){
        if(INSTANCE==null){
            INSTANCE=new GameView();
        }

        return INSTANCE;
    }

    public void gameStart(){
        System.out.println(START_MESSAGE);
    }

    public void printScore(Score score) {
        System.out.println(score.printScore());
    }
}
