package view;

public class UserView {

    private static UserView INSTANCE;

    private final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private UserView() {
    }

    public static UserView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserView();
        }

        return INSTANCE;
    }

    public void enterNumber() {
        System.out.println(NUMBER_INPUT_MESSAGE);
    }

    public void enterRestart() {
        System.out.println(GAME_RESTART_MESSAGE);
    }
}
