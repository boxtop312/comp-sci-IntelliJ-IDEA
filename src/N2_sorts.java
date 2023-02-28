import java.util.Arrays;

class N2_sorts{
    public static void bubbleSort(int arr[]){
        for(int i=arr.length;i>0;i--){
            for(int ii=0;ii<i-1;ii++){
                if (arr[ii]>arr[ii+1]){
                    int a = arr[ii];
                    int b= arr[ii+1];
                    arr[ii]=b;
                    arr[ii+1]=a;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int ii=0;ii<arr.length;ii++){
                if(arr[i]>arr[ii]){
                    for(int iii=ii;iii>i;iii--){
                        arr[iii]=arr[iii-1];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            int b=i;
            for(int ii=i;ii<arr.length;ii++) {
                if(arr[ii]<arr[i]){
                    a=arr[ii];
                    b=ii;
                }
            }
            arr[b]=arr[i];
            arr[i]=a;

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,5,6,3,4,2,8,7};
        bubbleSort(test);
        insertionSort(test);
        selectionSort(test);
    }
}