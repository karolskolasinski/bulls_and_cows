package bulls_and_cows;

class Messages {

    /*VARIABLES*/
    private String helloMessage =
            "  ____  _   _ _     _     ____                    _    ____ _____        ______  \n" +
                    " | __ )| | | | |   | |   / ___|    __ _ _ __   __| |  / ___/ _ \\ \\      / / ___| \n" +
                    " |  _ \\| | | | |   | |   \\___ \\   / _` | '_ \\ / _` | | |  | | | \\ \\ /\\ / /\\___ \\ \n" +
                    " | |_) | |_| | |___| |___ ___) | | (_| | | | | (_| | | |__| |_| |\\ V  V /  ___) |\n" +
                    " |____/ \\___/|_____|_____|____/   \\__,_|_| |_|\\__,_|  \\____\\___/  \\_/\\_/  |____/ \n" +
                    "                                                   by karolskolsinski@gamil.com\n";
    private String instructions = "Try to guess a 4-digit secret number. " +
            "The digits are all different. " +
            "Computer gives the number of matches. \n" +
            "If the matching digits are in their right positions, they are \"bulls\", if in different positions, they are \"cows\". \n" +
            "Example:\n" +
            "Secret number: 4271\n" +
            "Opponent's try: 1234\n" +
            "Answer: 1 bull and 2 cows [1B2C]. (The bull is \"2\", the cows are \"4\" and \"1\".)\n" +
            "You have 10 attempts to guess the secret code.\n";
    private String provideFourDigits = "Provide four digits:";


    /*METHODS*/
    void logoAndVersion() {
        System.out.println(helloMessage);
    }

    void instructions() {
        System.out.println(instructions);
    }

    void provideFourDigits() {
        System.out.println(provideFourDigits);
    }

    void end() {
        System.out.println("4B0C");
        System.out.println("YOU WON!");
    }

    void displayBullsAndCows(int bulls, int cows) {
        System.out.println(bulls + "B" + cows + "C");
    }

    void noMoreAttemptsLeft() {
        System.out.println("No more attempts left: YOU LOST!");
    }

    void attempts(int attempts) {
        System.out.print(attempts + 1 + "/10: ");
    }
}
