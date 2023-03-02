import java.util.Arrays;
public class Mege_Sort {

        public static int[] merge(int[] one, int[] two) {
            int[] res = new int[one.length+ two.length];
            int firstIdx = 0;
            int secondIdx = 0;
            int resIndex=0;
            while(firstIdx<one.length&&secondIdx< two.length){
                if (one[firstIdx] < two[secondIdx]) {
                    res[resIndex]=one[firstIdx];
                    firstIdx++;
                } else{
                    res[resIndex]=two[secondIdx];
                    secondIdx++;
                }
                resIndex++;
            }
            if(firstIdx==one.length){
                while ((secondIdx<two.length)){
                    res[resIndex]=two[secondIdx];
                    resIndex++;
                    secondIdx++;
                }
            }
            if(secondIdx== two.length){
                while(firstIdx<one.length){
                    res[resIndex]=one[firstIdx];
                    resIndex++;
                    firstIdx++;
                }
            }
            return res;
        }

        public static int[] mergeSort(int[] arr, int lo, int hi) {
            if(lo == hi){
                int[] x = {arr[lo]};
                return x;
            }
            int mid = (lo + hi) / 2;
            int[] fh = mergeSort(arr,lo, mid);
            int[] sh = mergeSort(arr,mid+1, hi);
            int[] res = merge(fh,sh);
            return res;
        }

        public static void main(String[] args) {
            System.out.println("Hello world!");
            int[] arr = { 70, 50, 30, 10, 20, 40, 60 };
            int[] merged = mergeSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(merged));
        }
    }
