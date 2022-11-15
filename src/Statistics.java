import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Statistics{
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        try {
            Scanner myReader = new Scanner(new File("numbers.txt"));
            while (myReader.hasNextLine()) {
                arr.add(Integer.parseInt(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static int Average(ArrayList<Integer> numlist){
        int average = 0;
        for(int i=0; i<numlist.size(); i++){
            average += numlist.get(i);
        }
        return average/numlist.size();
    }
}