package pl.edu.agh.hangman;

import java.util.Scanner;

public class Game {
    private String mysteryWord = "";
    private Checker checker;
    private String filename = "slowa.txt";
    private WordSelectorIn wordSelector;

    public Game(WordSelectorIn wordSelector) {
        this.wordSelector = wordSelector;
        this.mysteryWord = wordSelector.getWord();
        this.checker = new Checker(this.mysteryWord);
    }

    public void play(){
        System.out.println("Welcome to Hangman!");
        Scanner scanner = new Scanner(System.in);
        while (true){
            Display.show(this.checker.getNumberOfMistakes(), this.checker.getWordState());
            System.out.print("Guess a letter: ");
            char letter = Character.toUpperCase(scanner.next().charAt(0));
            this.checker.checkLetter(letter);
            if (this.checker.checkWin()){
                System.out.println("You won!");
                System.out.println(String.format("The mystery word is: %s", this.mysteryWord));
                Display.winImage();
                break;
            } else if (this.checker.getNumberOfMistakes() == Display.HANGMANPICS.length-1) {
                Display.show(Display.HANGMANPICS.length-1, checker.getWordState());
                System.out.println("You lost!");
                System.out.println(String.format("The mystery word is: %s", this.mysteryWord));
                Display.lossImage();
                break;
                
            }
        }
    }

}
