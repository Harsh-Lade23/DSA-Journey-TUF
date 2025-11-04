package stack_and_queues;

import java.util.Stack;

public class TrappingRainWater {
    static void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    /*
    for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && height[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                next[i]=-1;
                st.push(height[i]);
            }
            else{
                next[i]=st.peek();
                st.push(height[i]);
            }
        }
     */
    public int trap(int[] height) {
        int n=height.length;
        int[]prev =new int[n];
        int[] next=new int[n];
        Stack<Integer> st=new Stack<Integer>();
        next[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            next[i] = Math.max(height[i], next[i + 1]);
        }
        prev[0]=height[0];
        for(int i=1;i<n;i++){
            prev[i] = Math.max(height[i], prev[i-1]);
        }


        int finalWater=0;
        for (int i=0;i<n;i++){
            if(prev[i]== -1|| next[i]==-1)continue;
            int min=Math.min(prev[i], next[i]);
            finalWater=finalWater+(min-height[i]);

        }
        return finalWater;

    }
}
