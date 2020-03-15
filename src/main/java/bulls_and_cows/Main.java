package bulls_and_cows;


import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*VARIABLES*/
        boolean flag = false;
        Statement statement = new Statement();
        GameChecker gameChecker = new GameChecker(statement);

        /*MESSAGES*/
        statement.logoAndVersion();
        statement.instructions();
        statement.provideFourDigits();

        /*PARSER*/
        do {
            flag = gameChecker.checkDigits();
        } while (!flag);
    }

}
