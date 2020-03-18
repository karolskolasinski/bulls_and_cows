package bulls_and_cows;

import java.time.Duration;
import java.time.LocalDateTime;

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
    void logo() {
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

    void dispalyComputerDigits(String computerDigits) {
        System.out.println("Secret code was: " + computerDigits);
    }

    void displayGameTime(LocalDateTime startTime, LocalDateTime endTime) {
        String timeString = getGameTime(startTime, endTime);
        System.out.println(timeString);
    }

    private String getGameTime(LocalDateTime startTime, LocalDateTime endTime) {
        long totalSeconds = calcualteOverallDuration(startTime, endTime);
        long hours = calculateDurationInHours(totalSeconds);
        long minutes = calculateDurationInMinutes(totalSeconds);
        long seconds = calculateDurationInSeconds(totalSeconds);
        return String.format("Running time: %02d:%02d:%02d", hours, minutes, seconds);
    }

    private long calcualteOverallDuration(LocalDateTime startTime, LocalDateTime endTime) {
        return Duration.between(startTime, endTime).getSeconds();
    }

    private long calculateDurationInSeconds(long totalSeconds) {
        return totalSeconds % 60;
    }

    private long calculateDurationInMinutes(long totalSeconds) {
        return (totalSeconds % 3600) / 60;
    }

    private long calculateDurationInHours(long totalSeconds) {
        return totalSeconds / 3600;
    }
}
