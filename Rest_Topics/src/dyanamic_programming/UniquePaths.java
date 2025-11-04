package dyanamic_programming;

/**
 * Problem: Leetcode- 62. Unique Paths
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int [m][n];
        return helper(0,0,dp);
    }
    public int helper(int cl, int ro, int [][]dp){
        int endcl=dp[0].length-1;
        int endro=dp.length-1;
        if(cl==endcl && ro==endro)return 1;
        if(cl>endcl || ro> endro)return 0;
        if(dp[ro][cl]!=0)return dp[ro][cl];
        dp[ro][cl]=helper(cl, ro+1,  dp)+helper(cl+1, ro, dp);
        return dp[ro][cl];
    }
}
