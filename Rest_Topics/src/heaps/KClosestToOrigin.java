package heaps;

import java.util.PriorityQueue;

/**
 * Problem - Leetcode: 973. K Closest Points to Origin

 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).

 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> dist=new PriorityQueue<int[]>(
                (a,b)->(b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );
        for(int[] point: points){
            dist.add(point);
            if(dist.size()>k)dist.poll();
        }
        int [][] ans=new int[k][2];
        int index=0;
        while(!dist.isEmpty()){
            int[]cur=dist.poll();
            ans[index++]=cur;
        }
        return ans;
    }
}
