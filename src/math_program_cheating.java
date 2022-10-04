public class math_program_cheating {
    public static void main(String[] args) {
        int c=0;
        int a=0;
        int b=0;
        int counter = 0;
        String possibilites = "";
        while(true){
            if(13 == c*(c-a)*(c-b)){
                possibilites += ("A: "+ a + " B: "+ b+ " C: "+ c +"\n");
            }
            if(a>=100){
                a=0;
                b++;
            }else if(b>=100){
                b=0;
                c++;
            }else if(c>=100){
                c=0;
                System.out.println(possibilites);
                break;
            }
            if(!possibilites.equals("")){
                System.out.println(possibilites);
            }
            a++;
        }
    }

}
