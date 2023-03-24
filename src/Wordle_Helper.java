import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Wordle_Helper {
    public static void main(String[] args) {
        WordleHelper test = new WordleHelper();
        test.playGame();
    }
}

class WordleHelper{
    // Attribute
    private HashMap<String,Integer> wordbank = new HashMap<String,Integer>();
    private HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
    private String rankedLetters;
    HashMap<String,Integer> toRemove = new HashMap<String,Integer>();

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
        }
    }

    void wordsContainingLetter(char c){
        for(String s:wordbank.keySet()){
            char[] chars = s.toCharArray();
            boolean contains=false;
            for (char ch:chars) {
                if(ch==c){
                    contains=true;
                    break;
                }
            }
            if(!contains){
                toRemove.put(s,wordbank.get(s));
            }
        }
    }
    void wordsNotContainingLetter(char c){
        for(String s:wordbank.keySet()){
            char[] chars = s.toCharArray();
            boolean contains=false;
            for (char ch:chars) {
                if(ch==c){
                    contains=true;
                    break;
                }
            }
            if(contains){
                toRemove.put(s,wordbank.get(s));
            }
        }
    }
    void wordsContainingLetterAtIndex(char c, int i){
        for(String s:wordbank.keySet()){
            char[] chars = s.toCharArray();
            boolean contains=false;
            for(int x=0;x<chars.length;x++) {
                if(chars[x]==c&&x==i){
                    contains=true;
                    break;
                }
            }
            if(!contains){
                toRemove.put(s,wordbank.get(s));
            }
        }
    }
    void wordsNotContainingLetterAtIndex(char c, int i){
        for(String s:wordbank.keySet()){
            char[] chars = s.toCharArray();
            boolean contains=false;
            for(int x=0;x<chars.length;x++) {
                if(chars[x]==c&&x==i){
                    contains=true;
                    break;
                }
            }
            if(contains){
                toRemove.put(s,wordbank.get(s));
            }
        }

    }
    Map<Character, Integer> frequencyOfLettersInAllWords(){
        int[] thingi = new int[26];
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(String s:wordbank.keySet()){
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                for (int i = 0; i < thingi.length; i++) {
                    if (aChar == alphabet[i]) {
                        thingi[i] += 1;
                    }
                }
            }
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            map.put(alphabet[i],thingi[i]);
        }
        return map;
    }
    int scoreWord(String s){
        char[] chars = s.toCharArray();
        int score = 0;
        for (int i = 0; i < chars.length; i++) {
            for (Character c:frequencyOfLettersInAllWords().keySet()) {
                if(c==chars[i]){
                    score+=frequencyOfLettersInAllWords().get(c);
                }
            }
        }
        return score;
    }

    HashMap<String, Integer> rankWordBank(){
        System.out.println("first");
        for (String s:wordbank.keySet()) {
            wordbank.replace(s,scoreWord(s));
        }
        List<HashMap<String, Integer>> map = new ArrayList<HashMap<String, Integer>>();
//        HashMap<String,Integer>[] map = new HashMap[wordbank.size()+1];
        HashMap<String,Integer> toReturn = new HashMap<>();
        int count = 0;
        System.out.println("second");
        for (String s:wordbank.keySet()) {
            HashMap<String,Integer> thing = new HashMap<>();
            thing.put(s,wordbank.get(s));
            map.add(thing);
            count++;
        }
        System.out.println("third");
        for(int i=map.size();i>0;i--){
            for(int ii=0;ii<i-1;ii++){
                System.out.println(map.get(ii));
                System.out.println(map.get(ii).keySet());
                System.out.println(map.get(ii).get(map.get(ii).keySet()));
                if(map.get(ii).get(map.get(ii).keySet().toString())>map.get(ii+1).get(map.get(ii+1).keySet().toString())){
                    HashMap<String,Integer> a= new HashMap<>();
                    HashMap<String,Integer>b=new HashMap<>();
                    a.put(map.get(ii).keySet().toString(),map.get(ii).get(map.get(ii).keySet().toString()));
                    b.put(map.get(ii+1).keySet().toString(),map.get(ii+1).get(map.get(ii+1).keySet().toString()));
                    map.set(ii,b);
                    map.set(ii+1,a);
                }
            }
        }
        System.out.println("fourth");
        for (HashMap<String,Integer> h:map){
            toReturn.put(h.keySet().toString(),h.get(h.keySet().toString()));
        }
        return toReturn;
    }
    void playGame() {
        wordbank=rankWordBank();
        System.out.println("test");
        while (wordbank.size() > 0) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter the word you tried: ");
            String triedWord = myObj.nextLine();
            char[] triedWordC=triedWord.toCharArray();
            wordbank.remove(triedWord.toLowerCase());
            System.out.println("Enter color positions: \nGreen = g, Yellow = y, Black = b");
            myObj = new Scanner(System.in);
            String colors = myObj.nextLine();
            char[] colorsC=colors.toCharArray();
            toRemove.clear();
            boolean dupllicates = false;
            for (int j = 0; j < triedWordC.length; j++) {
                if(dupllicates){
                    break;
                }
                for (int k = j+1; k < triedWordC.length; k++) {
                    if(triedWordC[j]==triedWordC[k]){
                        dupllicates=true;
                        if(colorsC[j]=='b'){
                            wordsNotContainingLetter(triedWordC[j]);
                        }
                        if(colorsC[j]!='b'&&colorsC[k]=='b'){
                            wordsNotContainingLetterAtIndex(triedWordC[k],k);
                        }
                    }
                }
            }
            for (int i=0;i<triedWordC.length;i++) {
                if(!dupllicates) {
                    if (colorsC[i] == 'b') {
                        wordsNotContainingLetter(triedWordC[i]);
                    } else if (colorsC[i] == 'g') {
                        wordsContainingLetterAtIndex(triedWordC[i], i);
                    } else if (colorsC[i] == 'y') {
                        wordsNotContainingLetterAtIndex(triedWordC[i], i);
                    }
                } else{
                    if (colorsC[i] == 'g') {
                        wordsContainingLetterAtIndex(triedWordC[i], i);
                    } else if (colorsC[i] == 'y') {
                        wordsNotContainingLetterAtIndex(triedWordC[i], i);
                    }
                }
            }
            for (String s:toRemove.keySet()) {
                wordbank.remove(s);
            }
            for (String s:wordbank.keySet()) {
                System.out.println(s);
            }
        }
        System.out.println("End Of Line");
    }
}