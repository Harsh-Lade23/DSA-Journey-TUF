package dyanamic_programming;


import java.util.ArrayList;

/**
 * Problem: CSES Problem set- https://cses.fi/problemset/task/1637
 * You are given an integer n. On each step, you can subtract one of digits from it.
 * How many steps are required to make the number equal to 1.
 *
 */
public class RemovingDigits {
    public ArrayList<Integer> digits(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        while(n>0){
            if(n%10!=0)arr.add(n%10);
            n/=10;
        }
        return arr;
    }

    public int removingDigits(int n){
        int[]storage=new int[n+3];
        for(int i=1;i<=n;i++){
            if(i<10)storage[i]=1;
            else if(i==10)storage[i]=2;
            else {
                ArrayList<Integer> digits=digits(i);
                int min=Integer.MAX_VALUE;
                for(int dig: digits){
                    if(min>storage[i-dig])min=storage[i-dig];
                }
                storage[i]=min+1;
            }
        }
        return storage[n];
    }


}

