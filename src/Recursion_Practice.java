public class Recursion_Practice {

    // Impliment your functions from the practice phase here

    public static void printPascals(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascals(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascals(int row, int column) {
        if(row==column||column==0){
            return 1;
        }

        return pascals(row-1,column)+pascals(row-1,column-1);
    }

    public static int multiplication(int num1, int num2){
        if(num1==0||num2==0){
            return 0;
        }
        if(num1==1){
            return num2;
        }
        if(num2==1){
            return num1;
        }
        return num2+multiplication(num1-1,num2);
    }

    public static int fibonachi(int num){
        if(num<1){
            return 0;
        }
        if(num==1){
            return 1;
        }
        return fibonachi(num-1)+fibonachi(num-2);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Test your functions from the practice phase here
        printPascals(10);
        System.out.println(multiplication(7,20));
        System.out.println(fibonachi(10));
    }
}
