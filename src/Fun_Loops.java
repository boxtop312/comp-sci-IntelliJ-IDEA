public class Fun_Loops {
    public static String magicSquare(int num){
     int square = 0;
     int sortOfFactorial = 0;
     StringBuilder numlist = new StringBuilder();
     int count = 0;
     int i=0;
     int ii=0;
     while(true){
         square = i*i;
//         for(int ii=0;sortOfFactorial<square;ii++){
////             if(sortOfFactorial>=square){
//////                 System.out.println("count is going up");
////                 break;
////             }
//             sortOfFactorial+=ii;
//         }
         while(sortOfFactorial<square){
             sortOfFactorial+=ii;
             ii++;
         }
         if(sortOfFactorial==square){
             numlist.append(square).append(" ");
             count +=1;
         }
         if(count == num){
             break;
         }
//         System.out.println(square + ", " + sortOfFactorial);
         i++;
     }
     return(numlist.toString());
    }
    public static String leastCommonMultiple(double num1, double num2){
        double count = num1;
        while(count%num1 != count%num2){
            System.out.println(count%num1 + "  "+count%num2);
            count +=1;
        }
        System.out.println(count%num1 + "  "+count%num2);
        return(count+"");
    }
    public static void main(String[] args){
        System.out.println(leastCommonMultiple(7,70));
    }
}