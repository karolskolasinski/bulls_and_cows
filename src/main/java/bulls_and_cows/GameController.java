package bulls_and_cows;

import java.util.*;
import java.util.stream.Collectors;

class GameController {

    private Scanner scanner = new Scanner(System.in);
    private Messages messages;
    private ExceptionController exceptionController = new ExceptionController();
    private Random random = new Random();
    private Set<Integer> computerDigitsSet = new LinkedHashSet<>();
    private String userInput;
    private List<Integer> userDigitsList = new ArrayList<>();
    private List<Integer> computerDigitsList = new ArrayList<>();
    private int bulls;
    private int cows;

    GameController(Messages messages) {
        this.messages = messages;
        computerDigits();
    }

    boolean checkDigits() {
        if (isInputOnlyDigits()) {
            userInputToList();
            temporaryComputerDigits();
            return checkMatches();
        }
        return false;
    }

    private void temporaryComputerDigits() {
        computerDigitsList.clear();
        computerDigitsList.addAll(computerDigitsSet);
    }

    private void userInputToList() {
        userDigitsList.clear();
        userDigitsList = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean checkMatches() {
        countBullsCountCows();
        return getResult();
    }

    private boolean getResult() {
        if (bulls == 4) {
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
        for (int i = 0; i < computerDigitsList.size(); i++) {
            for (int j = 0; j < userDigitsList.size(); j++) {
                if (computerDigitsList.get(i).equals(userDigitsList.get(j))) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                    break;
                }
            }
        }
    }

    private boolean isInputOnlyDigits() {
        try {
            userInput = scanner.nextLine();
            checkIfInputContainsOnlyDigits(userInput);
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
        while (computerDigitsSet.size() != 4) {
            computerDigitsSet.add(random.nextInt(10));
        }
    }

}
