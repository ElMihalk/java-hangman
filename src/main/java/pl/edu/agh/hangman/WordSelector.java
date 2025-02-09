package pl.edu.agh.hangman;

import java.io.*;
import java.util.*;

public class WordSelector {

    public List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(fileName)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");

                for (String word : lineWords) {
                    words.add(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public String chooseRandomWord(List<String> words) {
        Random random = new Random();
        int index = random.nextInt(words.size());
        String word = words.get(index);
        return word;
    }

    public String toUpperCase(String word) {
        return word.toUpperCase();
    }

    public String selectWord(String fileName){
        List<String> words = readWordsFromFile(fileName);
        String word = chooseRandomWord(words);
        String finalWord = word.toUpperCase();
        return finalWord;
    }

}
