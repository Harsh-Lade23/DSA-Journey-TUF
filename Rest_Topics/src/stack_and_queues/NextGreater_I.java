package stack_and_queues;


import java.util.HashMap;
import java.util.Stack;

/**
 * Problem: 496. Next Greater Element I

 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.

 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above
 */
public class NextGreater_I {
    /*Follow up: Could you find an O(nums1.length + nums2.length) solution?*/

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp=new HashMap<>();
        int n2=nums2.length;
        int n=nums1.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n2-1;i>=0;i--){
            if(st.isEmpty()){
                mp.put(nums2[i], -1);
                st.push(nums2[i]);
                continue;
            }

            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                mp.put(nums2[i], -1);
            }
            else{
                mp.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }

        for(int i=0;i<n;i++){
            ans[i]=mp.get(nums1[i]);
        }
        return ans;

    }
}
