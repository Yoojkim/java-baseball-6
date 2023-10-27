package player;

import camp.nextstep.edu.missionutils.Randoms;
import score.Result;

public class Computer implements Player {

    private char[] number;

    public Computer() {
        number = new char[SIZE];
    }

    @Override
    public void setNumbers() {
        number = pickNumbers();
    }

    public Result compare(final int comparedIdx, final char comparedChar) {

        Result result = Result.NOTHING;
        for (int idx = 0; idx < SIZE; idx++) {
            if (comparedChar != number[idx]) {
                continue;
            }

            if (idx != comparedIdx) {
                result = Result.BALL;
                break;
            }

            result = Result.STRIKE;
        }

        return result;
    }

    private char[] pickNumbers() {
        boolean[] alreadyExist = new boolean[EXIST_SIZE];
        char[] randomNumbers = new char[SIZE];

        int idx = 0;
        while (idx < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);

            if (alreadyExist[randomNumber]) {
                continue;
            }

            randomNumbers[idx++] = (char) (START_NUMBER + randomNumber);
            alreadyExist[randomNumber] = true;
        }

        return randomNumbers;
    }
}

