package bulls_and_cows;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

class GameChecker {

    private Scanner scanner = new Scanner(System.in);
    private Statement statement;
    private Random random = new Random();
    private HashSet<Integer> computerDigits = new LinkedHashSet<>();
    private int i;

    GameChecker(Statement statement) {
        this.statement = statement;
        computerDigits();
        System.out.println(computerDigits);
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

    private void computerDigits() {
        while (computerDigits.size() != 4) {
            computerDigits.add(random.nextInt(10));
        }
    }

}
