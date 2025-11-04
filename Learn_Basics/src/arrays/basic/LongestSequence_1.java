package arrays.basic;

public class LongestSequence_1 {

    /**
     * 485. Max Consecutive Ones
     *
     * Given a binary array nums, return the maximum number of consecutive 1's in the array.
     *
     */
    public int longestSequenceOfOne(int []arr){
        int longestLen=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                int len=0;
                while(i<arr.length && arr[i]==1){
                    len++;
                    i++;
                }
                if(len>longestLen)longestLen=len;
            }
        }
        return longestLen;
    }
}
