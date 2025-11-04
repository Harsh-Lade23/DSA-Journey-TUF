package dyanamic_programming;

/**
 * Problem: Leetcode- 509. Fibonacci Number
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 *  such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */

public class FibonacciNumber {
    public int fib(int n) {

        // tabulation, iterative dp, bottom up
        if(n<=1)return n;
        int [] storage=new int[n+1];
        storage[0]=0;
        storage[1]=1;
        for(int i=2;i<=n;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[n];


        //Up bottom - recursive memoization.
/*
        if(n<=1)return n;
        int x;
        if(storage[n-1]!=0)x=storage[n-1];
        else x=fib(n-1);
        int y;
        if(storage[n-2]!=0)y=storage[n-2];
        else y=fib(n-2);
        storage[n]=x+y;
        return x+y;
*/
    }
}
