package bulls_and_cows;


public class Main {
    public static void main(String[] args) {

        /*VARIABLES*/
        boolean flag;
        Messages messages = new Messages();
        GameController gameController = new GameController(messages);

        /*MESSAGES*/
        messages.displayLogo();
        messages.displayInstructions();
        messages.displayMessageProvideFourDigits();

        /*PARSER*/
        do {
            flag = gameController.checkDigits();
        } while (!flag);
    }

}
