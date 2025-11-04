package recursion;

import java.util.Scanner;

public class CommonOperations {
    public int[] createArray(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length: ");
        int n=sc.nextInt();
        int []arr= new int[n];
        System.out.print("Enter elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    public void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public int[][] create2D_Array(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Dimensions: ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][]arr= new int[m][n];
        System.out.println("Enter elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }
    public void print2D_Array(int[][] arr){
        System.out.println("Array: ");
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
