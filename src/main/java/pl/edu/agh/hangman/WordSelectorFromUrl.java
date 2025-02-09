package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordSelectorFromUrl implements WordSelectorIn{

    String url;

    public WordSelectorFromUrl(String url) {
        this.url = url;
    }

    public String getWord(){
        String jsonResponse = getRandomWord();
        String word = extractWord(jsonResponse);
        word = word.toUpperCase();
        return word;
    }

    public static String extractWord(String jsonResponse) {
        String wordKey = "\"word\":\"";
        int startIndex = jsonResponse.indexOf(wordKey) + wordKey.length();
        int endIndex = jsonResponse.indexOf("\"", startIndex);

        return jsonResponse.substring(startIndex, endIndex);
    }

    public String getRandomWord() {
        try {
            URL url = new URL(this.url);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();

                return content.toString();
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        WordSelectorFromUrl wordSelector = new WordSelectorFromUrl("https://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5");
        System.out.println(wordSelector.getWord());

    }
}
