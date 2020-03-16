package bulls_and_cows;

import java.util.*;

class GameChecker {

    private Scanner scanner = new Scanner(System.in);
    private Messages messages;
    private Random random = new Random();
    private Set<Integer> computerDigitsSet = new LinkedHashSet<>();
    private String userDigitsString;

    GameChecker(Messages messages) {
        this.messages = messages;
        computerDigits();
        System.out.println(computerDigitsSet);
    }

    boolean checkDigits() {
        if (isInputOnlyDigits()) {
            return checkMatches();
        }
        return false;
    }

    private boolean checkMatches() {

        return true;
    }


    private boolean isInputOnlyDigits() {
        try {
            userDigitsString = scanner.nextLine();
            checkIfInputContainsOnlyDigits(Integer.parseInt(userDigitsString));
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
        while (computerDigitsSet.size() != 4) {
            computerDigitsSet.add(random.nextInt(10));
        }
    }

}
