package pl.edu.agh.hangman;

import java.util.HashSet;

public class Checker {
    private final String wordToGuess;
    private int gameState = 0;
    HashSet<Character> lettersToGuess = new HashSet<>();
    HashSet<Character> lettersFound = new HashSet<>();

    public Checker(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        for (char c : wordToGuess.toCharArray()) {
            this.lettersToGuess.add(c);
        }
    }

    public int getGameState() {
        return this.gameState;
    }

    public void checkLetter(char letter) {
        if (!lettersToGuess.contains(letter)) {
            this.gameState++;
        } else {
            this.lettersFound.add(letter);
        }
    }

    public String getWordState() {
        char[] letters = new char[this.wordToGuess.length()];
        int i =0;
        for (char c : this.wordToGuess.toCharArray()) {
            if (this.lettersFound.contains(c)){
                letters[i] = c;
            } else if (c == ' ') {
                letters[i] = ' ';
            } else {
                letters[i] = '_';
            }
            i++;
        }
        return new String(letters);
    }

    public boolean checkWin(){
        return this.lettersToGuess.equals(this.lettersFound);
    }
}
