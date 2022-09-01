public class StringTester {
    static String weatherCondition = "scattered thunderstorms";

    public static void main(String[] args){
        System.out.println(weatherCondition.length());
        System.out.println(weatherCondition.substring(weatherCondition.indexOf("thunder")));
        String weatherCondition1 = "mixed rain and snow";
        String weatherCondition2 = "mixed rain and snow";

        System.out.println((weatherCondition1 == weatherCondition2));
        System.out.println((weatherCondition1.equals(weatherCondition2)));

    }
}
