package pl.edu.agh.hangman;

import java.util.HashMap;
import java.util.Map;
import static pl.edu.agh.hangman.Hangman.HANGMANPICS;


public class Display {


    public static String[] HANGMANPICS = new String[]{
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
    public void setHangmanPics(String[] newPics) {
        this.HANGMANPICS = newPics;
    }


    public static void show(int stage, String currentWord) {
        if (stage < 0 || stage >= HANGMANPICS.length) {
            System.out.println("Invalid stage number. Only 7 stages available.");
            return;
        }

        System.out.println(HANGMANPICS[stage]);
        System.out.println("Current word: " + currentWord);
    }

    public static void winImage(){
        System.out.println("| (• ◡•)|");
    }

    public static void lossImage(){
        System.out.println("ᕙ(⇀‸↼‶)ᕗ");
    }


}



