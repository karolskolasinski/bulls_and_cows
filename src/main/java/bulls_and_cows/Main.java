package bulls_and_cows;


public class Main {
    public static void main(String[] args) {

        /*VARIABLES*/
        boolean flag;
        Messages messages = new Messages();
        GameController gameController = new GameController(messages);

        /*MESSAGES*/
        messages.logoAndVersion();
        messages.instructions();
        messages.provideFourDigits();

        /*PARSER*/
        do {
            flag = gameController.checkDigits();
        } while (!flag);
    }

}
