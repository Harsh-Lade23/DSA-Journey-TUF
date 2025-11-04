package arrays.medium;


/**
 * Problems - Leetcode: 53. Maximum Subarray

 * Given an integer array nums , find the subarray with the
 * largest sum, and return its sum.
 */
public class MaximumSumSubarray {
    public int maximumSum(int []arr){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if(sum>max)max=sum;
            if(sum<0)sum=0;
        }
        return max;
    }
}
