package bulls_and_cows;

import java.util.*;
import java.util.stream.Collectors;

class GameChecker {

    private Scanner scanner = new Scanner(System.in);
    private Messages messages;
    private Random random = new Random();
    private Set<Integer> computerDigitsOriginal = new LinkedHashSet<>();
    private String userInput;
    private List<Integer> userDigits = new ArrayList<>();
    private List<Integer> computerDigits = new ArrayList<>();

    GameChecker(Messages messages) {
        this.messages = messages;
        computerDigits();
        System.out.println(computerDigitsOriginal);
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
        computerDigits.addAll(computerDigitsOriginal);
    }

    private void userInputToList() {
        userDigits.clear();
        userDigits = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean checkMatches() {
        int bulls = checkBulls();
        checkCows();

        System.err.println(bulls);
        return false;
    }

    private int checkCows() {
        int cows = 0;
        return cows;
    }

    private int checkBulls() {
        int bulls = 0;
        for (int i = 0; i < computerDigits.size(); i++) {
            if (computerDigits.get(i).equals(userDigits.get(i))) {
                bulls++;
                computerDigits.remove(computerDigits.get(i));
            }
        }
        return bulls;
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
        if (!userInput.matches(".*\\d.{4}") && userInput.length() == 4) {
            throw new IllegalArgumentException("You can provide only digits!");
        } else if (userInput.length() < 4) {
            throw new IllegalArgumentException("You have to provide at least 4 digits!");
        } else if (userInput.length() > 4) {
            throw new IllegalArgumentException("You can provide only 4 digits!");
        }
    }

    private void computerDigits() {
        while (computerDigitsOriginal.size() != 4) {
            computerDigitsOriginal.add(random.nextInt(10));
        }
    }

}
