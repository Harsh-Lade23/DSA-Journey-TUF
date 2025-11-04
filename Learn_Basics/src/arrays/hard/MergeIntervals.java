package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem- Leetcode: 56. Merge Intervals
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    static void print2D_Array(int[][] arr){
        System.out.println("Array: ");
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        System.out.print("Sorted ");
        print2D_Array(intervals);
        List<int[]> mergedList = new ArrayList<>();
        mergedList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = mergedList.getLast();

            if (currentInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                mergedList.add(currentInterval);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
