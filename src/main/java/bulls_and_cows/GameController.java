package bulls_and_cows;

import java.util.*;

class GameController {

    private Scanner scanner = new Scanner(System.in);
    private Messages messages;
    private ExceptionController exceptionController = new ExceptionController();
    private Random random = new Random();
    private Set<Integer> computerDigits = new LinkedHashSet<>();
    private String userString;
    private String computerString;
    private int bulls;
    private int cows;
    private int attempts;

    GameController(Messages messages) {
        this.messages = messages;
        computerDigits();
    }

    boolean checkDigits() {
        if (isInputOnlyDigits()) {
            return checkMatches();
        }
        return false;
    }

    private void computerDigitsToString() {
        String s = computerDigits.toString();
        computerString = s.replaceAll("[\\[\\], ]", "");
    }

    private boolean checkMatches() {
        countBullsCountCows();
        return getResult();
    }

    private boolean getResult() {
        if (attempts == 10) {
            messages.displayBullsAndCows(bulls, cows);
            messages.noMoreAttemptsLeft();
            return true;
        } else if (bulls == 4) {
            messages.end();
            return true;
        } else {
            messages.displayBullsAndCows(bulls, cows);
            bulls = 0;
            cows = 0;
            return false;
        }
    }

    private void countBullsCountCows() {
        for (int i = 0; i < 4; i++) {
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
            messages.attempts(attempts);
            userString = scanner.nextLine();
            checkIfInputContainsOnlyDigits(userString);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private void checkIfInputContainsOnlyDigits(String userInput) {
        exceptionController.onlyDigits(userInput);
        exceptionController.lengthMoreThanFour(userInput);
        exceptionController.lengthLessThanFour(userInput);
        exceptionController.allDifferentDigits(userInput);
    }

    private void computerDigits() {
        while (computerDigits.size() != 4) {
            computerDigits.add(random.nextInt(10));
        }
        computerDigitsToString();
    }

}
