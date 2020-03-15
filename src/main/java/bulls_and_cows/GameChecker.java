package bulls_and_cows;

import java.util.Scanner;

class GameChecker {

    private Scanner scanner = new Scanner(System.in);
    private Statement statement;
    private int i;

    GameChecker(Statement statement) {
        this.statement = statement;
    }

    boolean checkDigits() {
        if (isInputOnlyDigits()) {
            try {
                checkIfInputContainsOnlyDigits();
                checkMatches();
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
        return false;
    }

    private void checkMatches() {

    }

    private boolean isInputOnlyDigits() {
        try {
            String s = scanner.nextLine();
            i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("You can provide only digits!");
        }
        return false;
    }

    private void checkIfInputContainsOnlyDigits() {
        if (i < 999) {
            throw new IllegalArgumentException("You have to provide at least 4 digits!");
        } else if (i > 9999) {
            throw new IllegalArgumentException("You can provide only 4 digits!");
        }
    }

}
