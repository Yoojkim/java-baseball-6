package player;

import camp.nextstep.edu.missionutils.Console;

public class User implements Player {
    private final int RESTART = 1;
    private final int END = 2;

    private char[] numbers;

    public User() {
        numbers = new char[SIZE];
    }

    @Override
    public void setNumbers() {
        char[] userNumbers = Console.readLine().toCharArray();

        numbersValidation(userNumbers);
        numbersUniqueValidation(userNumbers);
        numbers = userNumbers;
    }

    public boolean chooseGameEnd() {
        String userChoiceInput = Console.readLine();

        endInputStringValidation(userChoiceInput);

        int choice = Integer.parseInt(userChoiceInput);
        endInputNumberValidation(choice);

        if (choice == RESTART) {
            return false;
        }

        return true;
    }

    public char getNumber(final int index) {
        getNumberValidation(index);

        return numbers[index];
    }

    private void endInputStringValidation(final String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException("user input is too many");
        }
    }

    private void endInputNumberValidation(final int choice) {
        if (choice < RESTART || choice > END) {
            throw new IllegalArgumentException("user input is not appropriate");
        }
    }

    private void numbersValidation(char[] numbersInput) {
        if (numbersInput.length < SIZE) {
            throw new IllegalArgumentException("user input numbers size is smaller");
        }

        if (numbersInput.length > SIZE) {
            throw new IllegalArgumentException("user input numbers size is bigger");
        }

        for (char number : numbersInput) {
            if (number < MIN + START_NUMBER || number > MAX + START_NUMBER) {
                throw new IllegalArgumentException("user input is not appropriate");
            }
        }
    }

    private void numbersUniqueValidation(char[] numbersInput) {
        boolean[] alreadyExist = new boolean[EXIST_SIZE];

        for (char number : numbersInput) {
            number -= START_NUMBER;

            if (alreadyExist[number]) {
                throw new IllegalArgumentException("input number is not unique");
            }

            alreadyExist[number] = true;
        }
    }

    private void getNumberValidation(final int index) {
        if (index < 0 || index >= SIZE)
            throw new NullPointerException("input does not correspond to random number size");
    }
}
