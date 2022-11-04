import java.util.Arrays;
import java.util.Scanner;
public class Erastochines {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Primes upper bound: ");
        int num = input.nextInt();
        System.out.println("Computing Prime Numbers.\n");
        boolean[] primes = new boolean[num];
        Arrays.fill(primes, true);
        System.out.println("Primes between 1 and "+num+"\n");
        displayPrimes(computePrimes(primes));
    }
    public static boolean[] computePrimes(boolean[] primes){
        for(int i=2;i< primes.length;i++){
            for(int ii=i+i;ii<(primes.length);ii+=i){
                primes[ii]=false;
            }
        }
        return primes;
    }
    public static void displayPrimes(boolean[] primes){
        for(int i=1;i<primes.length;i++){
            if(primes[i]){
                if((""+i+"").length() ==1){
                    System.out.print("000"+i+" ");
                } else if ((i+"").length()==2){
                    System.out.print("00"+i+" ");
                }else if ((i+"").length()==3){
                    System.out.print("0"+i+" ");
                }
            }
        }
    }
}
