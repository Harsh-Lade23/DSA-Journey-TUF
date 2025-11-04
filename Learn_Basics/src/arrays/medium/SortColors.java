package arrays.medium;


/** Problem - Leetcode
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or
 * blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white, and
 * blue.
 * We will use the integers 0, 1 and 2 to represent the color
 * red, white, and blue, respectively.
 * You must solve this problem without using the library's sort
 * function.
 */


public class SortColors {
    public void printArray(int []arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public void sortColors(int[] arr){
        int flag0=0, flag2=0, flag1=0;

        while(flag2<arr.length ){
            if(arr[flag2]==0){
                if(arr[flag0]==1){
                    int temp=arr[flag0];
                    arr[flag0]=arr[flag2];
                    arr[flag2]=arr[flag1];
                    arr[flag1]=temp;
                    flag0++;
                    flag1++;
                }
                else{
                    int temp=arr[flag0];
                    arr[flag0]=arr[flag2];
                    arr[flag2]=temp;
                    flag0++;
                    flag1++;
                }
            }
            else if(arr[flag2]==1){
                int temp=arr[flag2];
                arr[flag2]=arr[flag1];
                arr[flag1]=temp;
                flag1++;
            }
            flag2++;

        }
    }
}








