public class Recusions {
    public int count8(int n) {
        if(n/10==0&&n%10!=8){
            return 0;
        }else if(n%10==8){
            return 1;
        }
        return count8(n)+(count8((int) (n/1*(Math.pow(10,(n+"".length()))))));
    }

    public static void main(String[] args){

    }
}
