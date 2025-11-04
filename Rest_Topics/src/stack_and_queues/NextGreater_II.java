package stack_and_queues;

import java.util.Stack;

public class NextGreater_II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int []arr=new int[n];
        for(int i =n-1;i>=0;i--){
            st.push(nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i]=-1;
            }
            else{
                arr[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return arr;
    }
}
