package stack_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=k-1;
        int []ans=new int[n-k+1];
        int max=Integer.MIN_VALUE;
        int j=0;
        System.out.println(right);
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<=right;i++){
            if(max<nums[i]){
                max=nums[i];
                j=i;
            }
            System.out.println("i= "+i+", will remove: "+(!st.isEmpty() && nums[st.getLast()]<=nums[i])+" "+st);
            while(!st.isEmpty() && nums[st.getLast()]<=nums[i]){
                st.removeLast();
            }
            st.offer(i);
        }
        System.out.println(st);
        int index=0;
        ans[index++]=max;

        while(right+1<n){
            if(nums[right+1]>=max){
                j=right+1;
                max=nums[right+1];
                while(!st.isEmpty() && nums[st.getLast()]<=nums[right+1]){
                    st.removeLast();
                }
                st.offer(right+1);
            }
            else{
                if(j==left){
                    st.removeFirst();
                    while(!st.isEmpty() && nums[st.getLast()]<=nums[right+1]){
                        st.removeLast();
                    }
                    st.offer(right+1);
                    max=nums[st.getFirst()];
                    j=st.getFirst();

                }
                else{
                    while(!st.isEmpty() && nums[st.getLast()]<=nums[right+1]){
                        st.removeLast();
                    }
                    st.offer(right+1);
                }
            }

            left++;
            right++;
            ans[index++]=max;
        }
        return ans;

    }
}
