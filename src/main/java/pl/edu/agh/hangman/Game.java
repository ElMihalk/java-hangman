package pl.edu.agh.hangman;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        WordSelector wordSelector = new WordSelector();
        String mysteryWord = wordSelector.selectWord("slowa.txt");

        Checker checker = new Checker(mysteryWord);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        int guesses = 0;
        while (true){
            Display.show(checker.getNumberOfMistakes(), checker.getWordState());
            System.out.print("Guess a letter: ");
            char letter = scanner.next().charAt(0);
            checker.checkLetter(letter);
            if (checker.checkWin()){
                System.out.println("You won!");
                System.out.println(String.format("The mystery word is: %s", mysteryWord));
                //TODO display image
                break;
            } else if (checker.getNumberOfMistakes() > 5) {
                Display.show(6, checker.getWordState());
                System.out.println("You lost!");
                System.out.println(String.format("The mystery word is: %s", mysteryWord));
                //TODO display image
                break;
            }
        }
    }
}
