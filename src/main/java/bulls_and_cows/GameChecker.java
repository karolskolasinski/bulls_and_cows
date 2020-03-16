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
        computerDigits.clear();
        computerDigits.addAll(computerDigitsOriginal);
    }

    private void userInputToList() {
        userDigits.clear();
        userDigits = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean checkMatches() {
        int bulls = countBulls();
        int cows = countkCows();
        return false;
    }

    private int countkCows() {
        return (int) computerDigits.stream().filter(integer -> userDigits.contains(integer)).count();
    }

    private int countBulls() {
        computerDigitsOriginal.forEach(integer -> {
            if (userDigits.indexOf(integer) != -1) {
                computerDigits.remove(integer);
            }
        });
        return 4 - computerDigits.size();
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
        if (!userInput.matches(".*\\d{4}") && userInput.length() == 4) {
            throw new IllegalArgumentException("You can provide only digits!");
        } else if (userInput.length() < 4) {
            throw new IllegalArgumentException("You have to provide at least 4 digits!");
        } else if (userInput.length() > 4) {
            throw new IllegalArgumentException("You can provide only 4 digits!");
        }//todo all different
    }

    private void computerDigits() {
        while (computerDigitsOriginal.size() != 4) {
            computerDigitsOriginal.add(random.nextInt(10));
        }
    }

}
