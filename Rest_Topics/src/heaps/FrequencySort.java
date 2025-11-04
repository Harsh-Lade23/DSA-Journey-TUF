package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int u:nums){
            map.put(u, map.getOrDefault(u,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>(
                (a,b)->{
                    if(!a.getValue().equals(b.getValue())){
                        return a.getValue()-b.getValue();
                    }
                    else return b.getKey()-a.getKey();

                }
        );
        pq.addAll(map.entrySet());
        int[] ans=new int[nums.length];
        int index=0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> p = pq.poll();
            int frequency = p.getValue();
            int number = p.getKey();

            for (int i = 0; i < frequency; i++) {
                ans[index++] = number;
            }
        }
        return ans;
    }
}
