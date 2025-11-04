package greedy;

import java.util.Arrays;

/*Problem: Leetcode -435. Non-overlapping Intervals
Given an array of intervals intervals where intervals[i] = [starti, endi],
 return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping.
 For example, [1, 2] and [2, 3] are non-overlapping.


 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{return a[1]-b[1];});
        int lastEnd=intervals[0][1];
        int ans=0;
        for(int i =1; i<intervals.length;i++){
            if(lastEnd>intervals[i][0]){
                ans++;
            }
            else{
                lastEnd=intervals[i][1];
            }
        }
        return ans;
    }

}
