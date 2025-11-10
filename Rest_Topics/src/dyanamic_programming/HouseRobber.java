package dyanamic_programming;

/**
 * Problem: Leetcode - 198. House Robber
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of
 * them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0], nums[1]);
        int []store=new int[nums.length];
        for(int i=0;i<nums.length;i++)store[i]=-1;
        helper(nums, 0, store);
        return store[0];
    }
    public int helper(int []nums, int idx, int[]store){
        if(idx==nums.length-2)return Math.max(nums[nums.length-2], nums[nums.length-1]);
        if(idx==nums.length-1)return nums[nums.length-1];
        int selectedSum;
        if(store[idx+2]!=-1)selectedSum=nums[idx]+store[idx+2];
        else selectedSum=nums[idx]+helper(nums, idx+2, store);

        int notSelectedSum;
        if(store[idx+1]!=-1)notSelectedSum=store[idx+1];
        else notSelectedSum=helper(nums, idx+1, store);

        store[idx]=Math.max(selectedSum, notSelectedSum);
        return store[idx];
    }
}
