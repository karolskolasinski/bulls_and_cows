package bulls_and_cows;

import java.util.Arrays;
import java.util.stream.Collectors;

class ExceptionController {

    void allDifferentDigits(String userInput) {
        if (Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()).size() != 4) {
            throw new IllegalArgumentException("The digits have to be all different!");
        }
    }

    void lengthLessThanFour(String userInput) {
        if (userInput.length() < 4) {
            throw new IllegalArgumentException("You must provide at least 4 digits!");
        }
    }

    void lengthMoreThanFour(String userInput) {
        if (userInput.length() > 4) {
            throw new IllegalArgumentException("You can provide only 4 digits!");
        }
    }

    void onlyDigits(String userInput) {
        if (!userInput.matches(".*\\d{4}") && userInput.length() == 4) {
            throw new IllegalArgumentException("You can provide only digits!");
        }
    }
}
