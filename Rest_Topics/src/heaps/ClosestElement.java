package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 658. Find K Closest Elements
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array. The result should also be sorted in ascending order.

 * An integer a is closer to x than an integer b if:

 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class ClosestElement {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Integer> pq=new PriorityQueue<>(
                    (a,b)-> {
                        int left=Math.abs(x-b);
                        int right=Math.abs(x-a);
                        if(left-right!=0)return left-right;
                        else return b-a;
                    }
            );
            for(int ele:arr){
                pq.add(ele);
                if(pq.size()>k)pq.poll();
            }
            PriorityQueue<Integer> ansQ=new PriorityQueue<>();

            List<Integer> ans=new ArrayList<Integer>();
            while(!pq.isEmpty()){
                ansQ.add(pq.poll());
            }
            while(!ansQ.isEmpty()){
                ans.add(ansQ.poll());
            }


            return ans;
        }

}
