public class Word_Scramble {
    public static String scrambleWord(String word){
        String word1 = word;
        Character char1;
        Character char2;
        for(int i =0; i<word.length(); i ++){
            if(i+2 <=word.length()&&word.charAt(i) == 'A'&&word.charAt(i+1) != 'A'){
                char1 = word.charAt(i);
                char2 = word.charAt(i+1);
                word1 = word1.substring(0,i) + char2 + char1 +word.substring(i+2);
            }else if(i+2 >=word.length()){
                word1 = word1;
            }

        }
        return word1;
    }
    public static void main(String[] args){
        System.out.println(scrambleWord("AARDVARK"));
    }
}
