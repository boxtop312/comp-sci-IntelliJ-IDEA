public class Palimdromes_and_piglatin {
    public static boolean reverable(String str) {
        String reversed;
        String str1;
        str1 = str;
        String str2;
        str2 = "";
        String[] stringArray = str1.toLowerCase().split("[^\\w+]");
//        System.out.println(Arrays.toString(stringArray));
        for(String word : stringArray){
//            System.out.println(word);
            str2 += word;
        }
//        System.out.println(str2);
        reversed = Palimdromes_and_piglatin_StringUtil.reverse(str2);
        return str2.equals(reversed);
    }
    public static String pigLatin(String str){
        String str1 = "";
        String string_array_i;
        String[] stringArray = str.split(" ");
        String[] stringArray1;
        for(int i=0; i< stringArray.length; i++){
            string_array_i = stringArray[i];
            switch (string_array_i.substring(0,1)) {case "a", "I", "A", "e", "E", "i", "o", "O", "u", "U" -> {stringArray[i] += "yay";}}
            if(string_array_i.charAt(0) != 'a'||string_array_i.charAt(0) != 'A'||string_array_i.charAt(0) != 'e'||string_array_i.charAt(0) != 'E'||string_array_i.charAt(0) != 'i'||string_array_i.charAt(0) != 'I'||string_array_i.charAt(0) != 'o'||string_array_i.charAt(0) != 'O'||string_array_i.charAt(0) != 'u'||string_array_i.charAt(0) != 'U'){
                for(int ii = 0; ii<string_array_i.length(); ii++){
                    if(ii>0&& !string_array_i.substring(string_array_i.length()-1).equals("a")&& !string_array_i.substring(string_array_i.length()-1).equals("A")&& !string_array_i.substring(string_array_i.length()-1).equals("e")&& !string_array_i.substring(string_array_i.length()-1).equals("E")&& !string_array_i.substring(string_array_i.length()-1).equals("i")&& !string_array_i.substring(string_array_i.length()-1).equals("I")&& !string_array_i.substring(string_array_i.length()-1).equals("o")&& !string_array_i.substring(string_array_i.length()-1).equals("O")&& !string_array_i.substring(string_array_i.length()-1).equals("u")&& !string_array_i.substring(string_array_i.length()-1).equals("U")){
                        if (string_array_i.substring(ii, ii + 1).equals("a")) {
                            stringArray1 = string_array_i.split("[a]");
                            stringArray[i] = "a" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("A")) {
                            stringArray1 = string_array_i.split("[A]");
                            stringArray[i] = "A" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("e")) {
                            stringArray1 = string_array_i.split("[e]");
                            stringArray[i] = "e" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("E")) {
                            stringArray1 = string_array_i.split("[E]");
                            stringArray[i] = "E" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("i")) {
                            stringArray1 = string_array_i.split("[i]");
                            stringArray[i] = "i" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("I")) {
                            stringArray1 = string_array_i.split("[I]");
                            stringArray[i] = "I" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("o")) {
                            stringArray1 = string_array_i.split("o");
                            stringArray[i] = "o" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("O")) {
                            stringArray1 = string_array_i.split("O");
                            stringArray[i] = "O" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("u")) {
                            stringArray1 = string_array_i.split("u");
                            stringArray[i] = "u" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("U")) {
                            stringArray1 = string_array_i.split("U");
                            stringArray[i] = "U" + stringArray1[1] + stringArray1[0] + "ay";
                            break;
                        }
                    } else if(ii>0){
                        if (string_array_i.substring(ii, ii + 1).equals("a")) {
                            stringArray1 = string_array_i.split("[a]");
                            stringArray[i] = "a" +  stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("A")) {
                            stringArray1 = string_array_i.split("[A]");
                            stringArray[i] = "A" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("e")) {
                            stringArray1 = string_array_i.split("[e]");
                            stringArray[i] = "e" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("E")) {
                            stringArray1 = string_array_i.split("[E]");
                            stringArray[i] = "E" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("i")) {
                            stringArray1 = string_array_i.split("[i]");
                            stringArray[i] = "i" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("I")) {
                            stringArray1 = string_array_i.split("[I]");
                            stringArray[i] = "I" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("o")) {
                            stringArray1 = string_array_i.split("o");
                            stringArray[i] = "o" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("O")) {
                            stringArray1 = string_array_i.split("O");
                            stringArray[i] = "O" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("u")) {
                            stringArray1 = string_array_i.split("u");
                            stringArray[i] = "u" + stringArray1[0] + "ay";
                            break;
                        } else if (string_array_i.substring(ii, ii + 1).equals("U")) {
                            stringArray1 = string_array_i.split("U");
                            stringArray[i] = "U" + stringArray1[0] + "ay";
                            break;
                    }
                    }
                }
            }
        }
        for(String word : stringArray){
            str1 += " "+ word;
        }
        str1 = str1.substring(1);
        if(!str1.contains("a")||!str1.contains("A")||!str1.contains("e")||!str1.contains("E")||!str1.contains("i")||!str1.contains("I")||!str1.contains("o")||!str1.contains("O")||!str1.contains("u")||!str1.contains("U")){
            str1 += "ay";
        }

        return(str1);
    }
    public static String shortHand(String str){
        String str1;
        str1 = str.replaceAll("and", "&");
        str1 = str1.replaceAll("you", "//");
        str1 = str1.replaceAll("to", "2");
        str1 = str1.replaceAll("for", "4");
        str1 = str1.replaceAll("a ", "");
        str1 = str1.replaceAll("i ","");
        str1 = str1.replaceAll("[aeiouAEIOU]", "");
        str1 = str1.replaceAll("//", "u");
        return(str1);
    }
    public static void main(String[] args) {
        System.out.println(pigLatin("hello"));
    }
}
