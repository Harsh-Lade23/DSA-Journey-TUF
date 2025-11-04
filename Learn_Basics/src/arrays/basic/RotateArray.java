package arrays.basic;


/**
 * Problem:
 * 189. Rotate Array

 * Given an integer array nums, rotate the array to the right by k steps,
 * where k is non-negative.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length<=1)return;
        int n=nums.length;
        int[] ans=new int[n];
        int actualRot=k%n;
        for(int i=0;i<actualRot;i++){
            ans[i]=nums[n-actualRot+i];
        }
        for(int i=actualRot;i<n;i++){
            ans[i]=nums[i-actualRot];
        }
        for(int i=0;i<n;i++){
            nums[i]=ans[i];
        }
    }

    /*Another Method:
    *Two pointers

    Step 1. Reverse the whole array.
    Step 2. Reverse array from 1 to k-1.
    Step 3. Reverse array from k-1 to n-1.


     */
}
