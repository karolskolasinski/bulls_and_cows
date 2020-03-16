package bulls_and_cows;


public class Main {
    public static void main(String[] args) {

        /*VARIABLES*/
        boolean flag = false;
        Messages messages = new Messages();
        GameChecker gameChecker = new GameChecker(messages);

        /*MESSAGES*/
        messages.logoAndVersion();
        messages.instructions();
        messages.provideFourDigits();

        /*PARSER*/
        do {
            flag = gameChecker.checkDigits();
        } while (!flag);
    }

}
