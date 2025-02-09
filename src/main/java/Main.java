import pl.edu.agh.hangman.Game;
import pl.edu.agh.hangman.WordSelectorFromFile;

import java.util.Scanner;

public class Main {

    public static final String[] newPICS = new String[]{
            "  +---+\n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "=========",
            "  +---+\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };


    public static void main(String[] args) {
        boolean replayFlag = true;
        Scanner scanner = new Scanner(System.in);
        while(replayFlag) {
            Game game1 = new Game(new WordSelectorFromFile("slowa.txt"));
            game1.play();
            while(true) {
                System.out.println("Would you like to play again? (y/n)");
                char answer = scanner.next().charAt(0);
                if (answer == 'y') {
                    replayFlag = true;
                    break;
                } else if (answer == 'n') {
                    replayFlag = false;
                    break;
                } else {
                    System.out.println("Wrong answer. Try again.");
                }
            }
        }
    }
}
