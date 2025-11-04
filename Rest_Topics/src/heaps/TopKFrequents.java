package heaps;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: 347. Top K Frequent Elements

 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class TopKFrequents {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp= new HashMap<>();

        for(int i:nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>(
                (a,b)->a.getValue()-b.getValue()
        );
        for(var e: mp.entrySet()){
            pq.add(e);
            if(pq.size()>k)pq.remove();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
