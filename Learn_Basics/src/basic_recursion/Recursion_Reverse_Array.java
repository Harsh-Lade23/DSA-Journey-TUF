package basic_recursion;


public class Recursion_Reverse_Array {
    public void reverseArray(int []arr,int n){
        //n is the last index of the array
        if (n<=0)return;

        reverseArray(arr, n-1);
        int lastVal=arr[n];

        for(int i=n;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=lastVal;
    }
}
