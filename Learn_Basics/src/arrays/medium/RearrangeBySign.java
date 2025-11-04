package arrays.medium;

/** Problem -Leetcode
 * 2149. Rearrange Array Elements by Sign
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 * You should return the array of nums such that the array follows the given conditions:
 * 1. Every consecutive pair of integers have opposite signs.
 * 2. For all integers with the same sign, the order in which they were present in nums is preserved.
 * 3. The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 */
public class RearrangeBySign {

    //Optimal
    public int[] rearrangeArray(int[] nums) {
        int pos=0, neg=1;
        int[] ans=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ans[neg]=nums[i];
                neg+=2;
            }
            else{
                ans[pos]=nums[i];
                pos+=2;
            }
        }
        return ans;
    }

    //Not Optimal
/*
    public int[] rearrangeArray(int[] nums) {
        int pos=0, neg=0, index=0;
        int[] ans=new int[nums.length];
        while(index<nums.length){
            while(nums[pos]<0){
                pos++;
            }
            while(nums[neg]>=0){
                neg++;
            }
            ans[index++]=nums[pos++];
            ans[index++]=nums[neg++];
        }
        return ans;
    }

*/

}
