package bulls_and_cows;

import java.util.Arrays;
import java.util.stream.Collectors;

import static bulls_and_cows.GameController.NUMBER_OF_DIGITS;

class UserInputValidator {

    void validateIfDigitsAreAllDifferent(String userInput) {
        if (Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()).size() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("The digits have to be all different!");
        }
    }

    void validateIfLengthIsLessThanFour(String userInput) {
        if (userInput.length() < NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("You must provide at least 4 digits!");
        }
    }

    void validateIfLengthIsMoreThanFour(String userInput) {
        if (userInput.length() > NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("You can provide only 4 digits!");
        }
    }

    void validateIfOnlyDigits(String userInput) {
        if (!userInput.matches(".*\\d{4}") && userInput.length() == NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("You can provide only digits!");
        }
    }
}
