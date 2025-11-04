package arrays.medium;

import java.util.HashMap;

public class SubArraysHavingSum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }
            if(map.containsKey(prefixSum)){
                map.put(prefixSum, map.get(prefixSum)+1);
            }
            else{
                map.put(prefixSum, 1);
            }
        }
        return count;


    }
}
