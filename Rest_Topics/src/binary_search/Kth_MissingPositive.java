package binary_search;

/**
 * Problem: Kth Missing Positive Number in a Sorted Array

 * Given a sorted array of distinct positive integers arr[],
 * You need to find the kth positive number that is missing from the arr[].
 */
public class Kth_MissingPositive {
    public int kthMissingPositive(int []arr, int k){
        if(arr[0]>k)return k;
        int left=0, right=arr.length-1;
        int leftCheck=0;
        while(left<=right) {
            int mid = (left + right) / 2;
            if (arr[mid] < mid + k + 1) {
                leftCheck = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return arr[leftCheck]+k-arr[leftCheck]+leftCheck+1;
    }
}
