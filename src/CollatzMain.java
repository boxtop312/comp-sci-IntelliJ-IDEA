import java.util.*;

public class CollatzMain {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the starting number: ");

        // takes input from the keyboard
        int name = Integer.parseInt(input.nextLine());
        Collatz one = new Collatz(Integer.parseInt(name+""));
        System.out.println(one);
    }
    static class Collatz{
        private int num;
        public Collatz(int num){
            this.num = num;
        }
        public int steps(){
            int num2 = this.num;
            int step = 0;
            if(num2==1){
                return step;
            }
            while(num2 > 1){
                if(num2%2==0){
                    num2/=2;
                } else{
                    num2 *=3;
                    num2+=1;
                }
                step++;
            }
            return step;
        }
        public int[] sequence(){
            int num2 = this.num;
            int[] numbers = new int[this.steps()];
            int step = 0;
            if(num2==1) {
                return new int[]{1};
            }
            while(num2 != 1){
                if(num2%2==0){
                    num2/=2;
                } else{
                    num2 *=3;
                    num2+=1;
                }
                numbers[step] = num2;
                step++;
            }
//            numbers[step+1]= 4;
//            numbers[step+2]=2;
//            numbers[step+3]=1;
            return numbers;
        }
        public int maxValue(){
            int max = 0;
            for(int i=0; i<sequence().length;i++){
                if(sequence()[i] > max){
                    max = sequence()[i];
                }
            }
            return max;
        }
        public int[] oddValues(){
            int oddNum = 0;
            for(int i=0; i<sequence().length;i++){
                if(sequence()[i]%2!=0){
                    oddNum++;
                }
            }
            int[] oddValue = new int[oddNum];
            int ii=0;
            for(int i=0;i<sequence().length; i++){
                if(sequence()[i]%2!=0){
                    oddValue[ii]=sequence()[i];
                    ii++;
                }
            }
            return oddValue;
        }
        public int minOddValue(){
            int minodd = 1;
            for(int i=0;i<oddValues().length;i++){
                if(oddValues()[i]<minodd){
                    minodd=oddValues()[i];
                }
            }
            return minodd;
        }
        public int sumValues(){
            int sum = 0;
            for(int i=0; i<sequence().length;i++){
                sum +=sequence()[i];
            }
            return sum;
        }
        public String stepList(){
            int num2 = this.num;
            int step = 0;
            StringBuilder stepListString = new StringBuilder();
            while(num2 != 1) {
                if (num2 % 2 == 0) {
                    num2 /= 2;
                    step++;
                    stepListString.append("Step ").append(step).append(": ").append(num2).append("\n");
                } else {
                    num2 *= 3;
                    num2 += 1;
                    step++;
                    stepListString.append("Step ").append(step).append(": ").append(num2).append("\n");
                }
            }
            return String.valueOf(stepListString);
        }
        public String toString(){
            return("Number of steps: "+this.steps()+"\nMaximum value: "+this.maxValue()+"\nMinimum odd value: "+this.minOddValue()+"\nList of odd values: "+ Arrays.toString(this.oddValues())+"\nSum of all values: "+this.sumValues()+"\n"+stepList());
        }
    }


}
