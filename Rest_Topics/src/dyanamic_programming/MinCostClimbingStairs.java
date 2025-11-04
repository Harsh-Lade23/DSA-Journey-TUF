package dyanamic_programming;


/**
 * Problem: Leetcode- 746. Min Cost Climbing Stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int []storage=new int[n];
        storage[0]=cost[0];
        storage[1]=cost[1];
        for(int i=2; i<n;i++ ){
            storage[i]=Math.min(storage[i-1], storage[i-2])+cost[i];
        }
        return Math.min(storage[n-1], storage[n-2]);
    }
}
