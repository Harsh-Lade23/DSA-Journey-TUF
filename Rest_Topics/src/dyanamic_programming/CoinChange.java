package dyanamic_programming;

import java.util.Arrays;


/**
 * Problem: Leetcode- 322. Coin Change
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 * You may assume that you have an infinite number of each kind of coin.
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        Arrays.sort(coins);
        int []storage=new int[amount+1];

        return helper2(coins, amount, storage);
    }
    private int helper(int[]coins, int amount, int[]storage){
        //Base Case
        if(amount<coins[0]){
            if(amount>=0)storage[amount]=-1;
            return -1;
        }
        for(int i=0;i<coins.length;i++){
            if(coins[i]==amount){
                storage[amount]=1;
                return 1;
            }
        }

        //Self work
        if(storage[amount]!=-2)return storage[amount];
        int minCoin=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int a=helper(coins, amount-coins[i], storage);
            if(a!=-1 && a<minCoin)minCoin=a;
        }

        if(minCoin==Integer.MAX_VALUE){
            storage[amount]=-1;
            return -1;
        }
        else {
            storage[amount]=minCoin+1;
            return minCoin+1;
        }


    }

    //Bottom Up
    private int helper2(int[]coins, int amount, int[]dp){
        Arrays.fill(dp, amount+1);

        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];


    }
}
