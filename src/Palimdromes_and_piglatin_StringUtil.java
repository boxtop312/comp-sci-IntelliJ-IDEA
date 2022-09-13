public class Palimdromes_and_piglatin_StringUtil {
    public static void sayHello(){
        Palimdromes_and_piglatin_StringUtil.sayHello();
    }

    public static String reverse(String phrase){
        String reversed = "";
        int length = phrase.length();
        int x = 1;
        while (length-x >= 0){
            reversed += phrase.substring(length-x,length-x+1);
            x++;
        }
        return reversed;
    }
}