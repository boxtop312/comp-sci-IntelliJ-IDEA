import java.io.*;
import java.util.*;

class DecodeMessage{

    // Helper function to sort a HashMap by Value
    // Returns result as an ArrayList of Entry<Character  , Double>
    // Feel free to ignore or modify this however you see fit
    public static ArrayList<Map.Entry<Character, Integer>> sortMap(Map<Character, Integer> freq) {
        ArrayList<Map.Entry<Character, Integer>> l = new ArrayList<Map.Entry<Character, Integer>>();
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
            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Double> percentMap1 = new HashMap<>();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String cleanData = data.toLowerCase().replaceAll("[^qwertyuiopasdfghjklzxcvbnm]", "");
                char[] cCleanData = cleanData.toCharArray();
                for (char c : cCleanData) {
                    if (map.get(c) == null) {
                        map.put(c, 1);
                    } else {
                        map.put(c, map.get(c) + 1);
                    }
                }
                double count = 0.0;
                for (int i : map.values()) {
                    count += i;
                }
                double thing = 100.0 / count;
                for (char c : map.keySet()) {
                    percentMap1.put(c, map.get(c) * thing);
                }
            }
            fileReader.close();

            Scanner fileReader2 = new Scanner(f2);
            Map<Character, Integer> map2 = new HashMap<>();
            Map<Character, Double> percentMap2 = null;
            while (fileReader2.hasNextLine()) {
                String data = fileReader2.nextLine();
                String cleanData = data.toLowerCase().replaceAll("[^qwertyuiopasdfghjklzxcvbnm]", "");
                char[] cCleanData = cleanData.toCharArray();
                for (char c : cCleanData) {
                    if (map2.get(c) == null) {
                        map2.put(c, 1);
                    } else {
                        map2.put(c, map2.get(c) + 1);
                    }
                }
                double count = 0.0;
                for (int i : map2.values()) {
                    count += i;
                }
                double thing = 100.0 / count;
                percentMap2 = new HashMap<>();
                for (char c : map2.keySet()) {
                    percentMap2.put(c, map2.get(c) * thing);
                }
            }
            fileReader2.close();

            // TODO: map frequencies
            Map<Character, Character> converstionMap = new HashMap<>();
            ArrayList<Map.Entry<Character, Integer>> sortedPercentMap1 = sortMap(map);
            ArrayList<Map.Entry<Character, Integer>> sortedPercentMap2 = sortMap(map2);
            for (int i = 0; i < sortedPercentMap1.size(); i++) {
                converstionMap.put(sortedPercentMap2.get(i).getKey(),sortedPercentMap1.get(i).getKey());
            }
            System.out.println(converstionMap);
            // TODO: decrypt the message
            String message = "Mxkgz Puh eua jkixevzkj znk zkdz!";
            char[] cMessage = message.toLowerCase().replaceAll("[^qwertyuiopasdfghjklzxcvbnm]", "").toCharArray();
            char[] decrypted = new char[message.length()];
            for (int i=0;i<cMessage.length;i++) {
                decrypted[i]=converstionMap.get(cMessage[i]);
            }
            System.out.println(decrypted);

        } catch (FileNotFoundException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
