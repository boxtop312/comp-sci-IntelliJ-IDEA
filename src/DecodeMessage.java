import java.io.*;
import java.util.*;

class DecodeMessage{

    // Helper function to sort a HashMap by Value
    // Returns result as an ArrayList of Entry<Character  , Double>
    // Feel free to ignore or modify this however you see fit
    public static ArrayList<Map.Entry<Character, Double>> sortMap(HashMap<Character, Double> freq) {
        ArrayList<Map.Entry<Character, Double>> l = new ArrayList<Map.Entry<Character, Double>>();
        freq.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> l.add(k));
        System.out.println(l);
        return l;
    }

    public static void main(String[] args) {
        try {

            File f1 = new File("warAndPeace.txt");
            File f2 = new File("intercept.txt");

            Scanner fileReader = new Scanner(f1);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // TODO: build frequency table for english
            }
            fileReader.close();

            Scanner fileReader2 = new Scanner(f2);
            while (fileReader2.hasNextLine()) {
                String data = fileReader2.nextLine();
                // TODO: build frequency table for encrypted text
            }
            fileReader2.close();

            // TODO: map frequencies

            // TODO: decrypt the message
            String message = "Mxkgz Puh eua jkixevzkj znk zkdz!";

        } catch (FileNotFoundException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
