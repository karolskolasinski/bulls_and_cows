package bulls_and_cows;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

class Statement {

    /*VARIABLES*/
    private String version = getAppVersion();
    private String helloMessage =
            "  ____  _   _ _     _     ____                    _    ____ _____        ______  \n" +
                    " | __ )| | | | |   | |   / ___|    __ _ _ __   __| |  / ___/ _ \\ \\      / / ___| \n" +
                    " |  _ \\| | | | |   | |   \\___ \\   / _` | '_ \\ / _` | | |  | | | \\ \\ /\\ / /\\___ \\ \n" +
                    " | |_) | |_| | |___| |___ ___) | | (_| | | | | (_| | | |__| |_| |\\ V  V /  ___) |\n" +
                    " |____/ \\___/|_____|_____|____/   \\__,_|_| |_|\\__,_|  \\____\\___/  \\_/\\_/  |____/ \n" +
                    "                                                           version " + version + "\n";
    private String instructions = "Try to guess a 4-digit secret number. " +
            "The digits are all different. " +
            "Computer gives the number of matches. \n" +
            "If the matching digits are in their right positions, they are \"bulls\", if in different positions, they are \"cows\". \n" +
            "Example:\n" +
            "Secret number: 4271\n" +
            "Opponent's try: 1234\n" +
            "Answer: 1 bull and 2 cows [1B2C]. (The bull is \"2\", the cows are \"4\" and \"1\".)\n";
    private String provideFourDigits = "Provide four digits:";


    /*METHODS*/
    void logoAndVersion() {
        System.out.println(helloMessage);
    }

    private String getAppVersion() {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        String version = "unknown";
        try {
            Model model = reader.read(new FileReader("pom.xml"));
            version = model.getVersion();
        } catch (IOException | XmlPullParserException e) {
            System.err.println(e.getMessage());
            System.err.println("version cannot be read: version unknown");
        }
        return version;
    }

    void instructions() {
        System.out.println(instructions);
    }

    void provideFourDigits() {
        System.out.println(provideFourDigits);
    }

}
