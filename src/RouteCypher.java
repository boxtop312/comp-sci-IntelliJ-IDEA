import java.lang.Math;
import java.util.Arrays;

public class RouteCypher {
    public static void main(String[] args){
        RouteCypher one = new RouteCypher();
//        one.numCols = 5;
//        one.numRows = 2;
        System.out.println(one.encryptMessage("Meet at midnight"));
    }
    /** A two-dimensional array of single-character strings,
     instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Places a string into letterBlock in row-major order.
     *   @param str the string to be processed
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    private void fillBlock(String str) {
        numCols = (int)(Math.random() * (10 - 3 + 1) + 3);
        numRows = (int)(Math.random() * (10 - 3 + 1) + 3);
        while(numCols*numRows<str.length()){
            numCols = (int)(Math.random() * (10 - 3 + 1) + 3);
            numRows = (int)(Math.random() * (10 - 3 + 1) + 3);
        }
        while(str.length()>numRows*numCols){
            numRows++;
        }

        letterBlock = new String[numRows][numCols];
        StringBuilder strBuilder = new StringBuilder(str);
        int count = 0;
//        System.out.println(str);
        for(int i = 0; i<(numRows*numCols)-str.length(); i++){
            strBuilder.append("#");
        }
        str = strBuilder.toString();
//        System.out.println(str);
        for(int y = 0; y<numRows; y++){
            for(int x=0;x<numCols;x++){
                letterBlock[y][x] = String.valueOf(str.charAt(count));
//                System.out.println(str.charAt(count));
                count ++;
            }
        }

    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *   Precondition: letterBlock has been filled
     *   @return the encrypted string from letterBlock
     */
    private String encryptBlock() {
        /* implementation not shown */
        StringBuilder builderString = new StringBuilder();
        for(int x=0;x<numCols;x++){
            for(int y = 0;y<numRows;y++){
                builderString.append(letterBlock[y][x]);
            }
        }
        return(builderString.toString());
    }

    /** Encrypts a message.
     *   @param message the string to be encrypted
     *   @return the encrypted message;
     *           if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message) {
        /* to be implemented in part (b) */
        numCols = (int)(Math.random() * (10 - 3 + 1) + 3);
        numRows = (int)(Math.random() * (10 - 3 + 1) + 3);
        while(numCols*numRows<message.length()){
            numCols = (int)(Math.random() * (10 - 3 + 1) + 3);
            numRows = (int)(Math.random() * (10 - 3 + 1) + 3);
        }
//        int randomNum = (int)(Math.random() * (10 - 2 + 1) + 2);


        StringBuilder strBuilder = new StringBuilder(message);
        for(int i = 0; i<(numRows*numCols)-message.length(); i++){
            strBuilder.append("#");
        }

        message = strBuilder.toString();
        String[] splitMessage = new String[numRows];
        Arrays.fill(splitMessage, "");
        for(int i=0;i<numRows;i++){
            for(int ii=0;ii<numCols;ii++){
                splitMessage[i] += message.charAt(ii+(i*numCols));
            }
        }
        StringBuilder thing;
        thing = new StringBuilder();
        for(String str:splitMessage){
//            System.out.println(this.toString());
            fillBlock(str);
            thing.append(this.encryptBlock());

        }
        String thing2 = thing.toString();
        thing2 = thing2.replaceAll("#", "");
        fillBlock(thing2);
        return this.encryptBlock().replaceAll("#", "");
    }

    // There may be instance variables, constructors, and methods that are not shown
}
