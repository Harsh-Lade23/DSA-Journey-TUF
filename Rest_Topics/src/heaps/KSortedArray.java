package heaps;


import java.util.PriorityQueue;

/**
 * Problem: Sort a k sorted array (nearly sorted array)
 */
public class KSortedArray {
    public void sortArray(int[]arr, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int left=0, right=0;
        while(left<arr.length){
            if(right<arr.length) {
                pq.add(arr[right]);
                right++;
                if(pq.size()>k){
                    arr[left++]=pq.remove();
                }
            }
            else {
                arr[left++]=pq.remove();
            }

        }
    }
}
