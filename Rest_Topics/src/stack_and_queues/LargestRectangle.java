package stack_and_queues;

import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int []prev=new int[n];
        int []next=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                prev[i]=-1;
            }
            else{
                prev[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        Stack<Integer> st2= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st2.isEmpty() && heights[st2.peek()]>=heights[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                next[i]=-1;
            }
            else{
                next[i]=st2.peek();
            }
            st2.push(i);
        }
        System.out.print("next: ");
        printArray(next);
        System.out.print("Prev: ");
        printArray(prev);
        System.out.println();
        int max=0;

        System.out.println("\n\n");
        for(int i=0;i<n;i++){
            int left, right;
            if(prev[i]==-1)left=0;
            else left=prev[i];

            if(next[i]==-1)right=n;
            else right=next[i]-1;
            System.out.printf("i = %d, left= %d, right= %d, mx= %d\n",i,left,right,(right-left)*heights[i]);
            if(max<(right-left)*heights[i])max=(right-left)*heights[i];
        }
        return max;
    }
    static void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

}
