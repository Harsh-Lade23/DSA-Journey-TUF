package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: Find the Kth minimum element in given array.
 */
public class KthMinElements {
    public int findKthMin(int []arr, int k){
        if(arr.length==0 )return -1;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.poll();
    }
}
