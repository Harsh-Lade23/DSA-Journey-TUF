package stack_and_queues;

import java.util.Stack;

public class MinimumInSubarray {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int []next=new int[n];
        int []prev=new int[n];
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2 =new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st1.isEmpty() && arr[st1.peek()]>=arr[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                next[i]=-1;
            }
            else next[i]=st1.peek();
            st1.push(i);
        }
        for(int i=0;i<n;i++){
            while(!st2.isEmpty() && arr[st2.peek()]>arr[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                prev[i]=-1;
            }
            else prev[i]=st2.peek();
            st2.push(i);
        }
        System.out.print("Prev ");
        printArray(prev);
        System.out.println();
        System.out.print("Next ");
        printArray(next);
        System.out.println();
        long ans=0L;
        for(int i=0;i<n;i++){
            int left, right;
            if(next[i]==-1)right=n-i;
            else right=next[i]-i;
            if(prev[i]==-1)left=1+i;
            else left=i-prev[i];
            ans+=(long) right*left*arr[i];
            ans=ans%1000000007;
            System.out.printf("i=%d, arr[i]=%d, prev[i]=%d, next[i]=%d, left=%d, right=%d, ans=%d\n", i, arr[i], prev[i], next[i], left, right, ans);
        }
        int j=(int)ans;
        return j;
    }

    static void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
