import pl.edu.agh.hangman.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean replayFlag = true;
        Scanner scanner = new Scanner(System.in);
        while(replayFlag) {
            Game game1 = new Game("slowa.txt");
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
