package dyanamic_programming;


/**
 * Problem: Given a number n, you can perform any of the given operations:
 * 1. Make n to n-1.
 * 2. If n is divisible by 2, make it n/2.
 * 3. If n is divisible by 3, make it n/3.

 * Find out, in how many minimum no of steps you required to reduce n to 1.
 *
 */
public class NTo1 {
    public int stepsToReachOne(int n){
        int []dp=new int[n+3];
        helper(n, dp);
        return 0;
    }
    private int helper(int n, int []dp){
        if(n==1)return 0;
        if(n==2 || n==3)return 1;

        if(dp[n]!=0)return dp[n];

        dp[n]=Math.min(Math.min(helper(n-1, dp), helper(n/2, dp)), helper(n/3, dp));
        return dp[n];
    }

}
