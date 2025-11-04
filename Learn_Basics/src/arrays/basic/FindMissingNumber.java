package arrays.basic;

public class FindMissingNumber {
    public int missingNumber(int []arr){
        if(arr.length<=1)return -2;
        int arrSum=0;
        for (int j : arr) {
            arrSum += j;
        }
        int sum=(arr.length*(arr.length+1)/2);
        return sum-arrSum;
    }
}
