package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSelectorFromFile implements WordSelectorIn {

    public String filename;

    public WordSelectorFromFile(String filename) {
        this.filename = filename;
    }

    @Override
    public String getWord() {
        List<String> words = readWordsFromFile();
        String word = chooseRandomWord(words);
        String finalWord = word.toUpperCase();
        return finalWord;
    }

    public List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(this.filename)))) {
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


}
