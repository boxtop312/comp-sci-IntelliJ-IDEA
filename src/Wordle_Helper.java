import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Wordle_Helper {
    public static void main(String[] args) {
        WordleHelper test = new WordleHelper();
    }
}

class WordleHelper{
    // Attribute
    private HashMap<String,Integer> wordbank = new HashMap<String,Integer>();
    private HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
    private String rankedLetters;

    // Constructor
    public WordleHelper(){
        // Access the text file, extract all five-letter words and store in arraylist
        ArrayList<String> bank = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("wordbank.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                bank.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Transfer words to a hashmap. Word is the key, the word's score will be the value.
        // Currently each word has a score of zero.
        for(String word: bank){
            wordbank.put(word,0);
            System.out.println(word+": "+wordbank.get(word));
        }
        System.out.println(wordbank.size());
    }
}