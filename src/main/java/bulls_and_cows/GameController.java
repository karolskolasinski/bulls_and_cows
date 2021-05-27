package bulls_and_cows;

import java.time.LocalDateTime;
import java.util.*;

class GameController {

    private final Scanner scanner = new Scanner(System.in);
    private Messages messages;
    private final UserInputValidator userInputValidator = new UserInputValidator();
    private final Random random = new Random();
    private final Set<Integer> computerDigits = new LinkedHashSet<>();
    private String userString;
    private String computerString;
    private int bulls;
    private int cows;
    private int attempts;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    static final int NUMBER_OF_DIGITS = 4;

    GameController() {
    }

    GameController(Messages messages) {
        this.messages = messages;
        randomizeComputerDigitsToList();
        startTime = LocalDateTime.now();
    }

    boolean checkDigits() {
        if (isInputOnlyDigits()) {
            return checkMatches();
        }
        return false;
    }

    private void transformComputerDigitsToString() {
        String s = computerDigits.toString();
        computerString = s.replaceAll("[\\[\\], ]", "");
    }

    private boolean checkMatches() {
        countBullsCountCows();
        return getResult();
    }

    private boolean getResult() {
        if (attempts == 10) {
            endTime = LocalDateTime.now();
            messages.displayBullsAndCows(bulls, cows);
            messages.displayNoMoreAttemptsLeft();
            messages.displayComputerDigits(computerString);
            messages.displayGameTime(startTime, endTime);
            return true;
        } else if (bulls == NUMBER_OF_DIGITS) {
            messages.displayTheEnd();
            messages.displayGameTime(startTime, endTime);
            return true;
        } else {
            messages.displayBullsAndCows(bulls, cows);
            bulls = 0;
            cows = 0;
            return false;
        }
    }

    void countBullsCountCows() {
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (userString.charAt(i) == computerString.charAt(i)) {
                bulls++;
            } else if (computerString.contains(userString.charAt(i) + "")) {
                cows++;
            }
        }
        attempts++;
    }

    private boolean isInputOnlyDigits() {
        try {
            messages.displayAttempts(attempts);
            userString = scanner.nextLine();
            validateUserInput(userString);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private void validateUserInput(String userInput) {
        userInputValidator.validateIfOnlyDigits(userInput);
        userInputValidator.validateIfLengthIsMoreThanFour(userInput);
        userInputValidator.validateIfLengthIsLessThanFour(userInput);
        userInputValidator.validateIfDigitsAreAllDifferent(userInput);
    }

    void randomizeComputerDigitsToList() {
        while (computerDigits.size() != NUMBER_OF_DIGITS) {
            computerDigits.add(random.nextInt(10));
        }
        transformComputerDigitsToString();
    }

    void setUserString(String userString) {
        this.userString = userString;
    }

    String getComputerString() {
        return computerString;
    }

    int getBulls() {
        return bulls;
    }

    int getCows() {
        return cows;
    }
}
