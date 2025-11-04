package arrays.medium;

public class RotateArrayClockwise {
    public void rotateArray_90Degree(int [][]arr){
        helper(arr, 0, arr.length);
    }
    private void helper(int [][]arr, int i, int n){
        if(i>=n-1)return;
        int k=0;
        for(int j=i; j<n-1;j++){
            int temp=arr[i][j];
            arr[i][j]=arr[n-1-k][i];
            arr[n-1-k][i]=arr[n-1][n-1-k];
            arr[n-1][n-1-k]=arr[j][n-1];
            arr[j][n-1]=temp;

            k++;
        }
        System.out.println();
        System.out.println();

        helper(arr, i+1, n-1);
    }


    static void print2D_Array(int[][] arr){
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
