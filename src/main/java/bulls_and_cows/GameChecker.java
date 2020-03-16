package bulls_and_cows;

import java.util.*;
import java.util.stream.Collectors;

class GameChecker {

    private Scanner scanner = new Scanner(System.in);
    private Messages messages;
    private Random random = new Random();
    private Set<Integer> computerDigits = new LinkedHashSet<>();
    private String userInput;
    private List<Integer> userDigits = new ArrayList<>();

    GameChecker(Messages messages) {
        this.messages = messages;
        computerDigits();
        System.out.println(computerDigits);
    }

    boolean checkDigits() {
        if (isInputOnlyDigits()) {
            userInputToList();
            return checkMatches();
        }
        return false;
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

        return false;
    }

    private int checkCows() {
        int cows = 0;
        return cows;
    }

    private int checkBulls() {

    }

    private boolean isInputOnlyDigits() {
        try {
            userInput = scanner.nextLine();
            checkIfInputContainsOnlyDigits(Integer.parseInt(userInput));
            return true;
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                System.err.println("You can provide only digits!");
            } else {
                System.err.println(e.getMessage());
            }

        }
        return false;
    }

    private void checkIfInputContainsOnlyDigits(int userDigits) {
        if (userDigits < 999) {
            throw new IllegalArgumentException("You have to provide at least 4 digits!");
        } else if (userDigits > 9999) {
            throw new IllegalArgumentException("You can provide only 4 digits!");
        }
    }

    private void computerDigits() {
        while (computerDigits.size() != 4) {
            computerDigits.add(random.nextInt(10));
        }
    }

}
