import backtracking.*;
import binary_search.KokoAndBanana;
import binary_search.Kth_MissingPositive;
import binary_search.MinimumCommonValue;
import binary_tree.*;
import greedy.BurstBalloons;
import greedy.LargestString;
import heaps.KSortedArray;
import heaps.MinHeap;
import recursion.StringToInteger;
import recursion.Subset;
import sliding_window.BinarrySubarraySum;
import stack_and_queues.LargestRectangle;
import stack_and_queues.MaximumSlidingWindow;
import stack_and_queues.MinimumInSubarray;
import stack_and_queues.TrappingRainWater;

import java.util.Scanner;

public class Main {

    static int[] createArray(){
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
    static void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    static int[][] create2D_Array(){
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
    static char[][] create2D_CharArray(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Dimensions: ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        char [][]arr= new char[m][n];
        System.out.println("Enter elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }
        return arr;
    }
    static void print2D_Array(int[][] arr){
        System.out.println("Array: ");
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void print2D_CharArray(char[][] arr){
        System.out.println("Array: ");
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] []arr= create2D_Array();
        BurstBalloons bn= new BurstBalloons();
        System.out.println(bn.findMinArrowShots(arr));

    }
}