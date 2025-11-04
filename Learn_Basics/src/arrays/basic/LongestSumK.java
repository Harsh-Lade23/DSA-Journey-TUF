package arrays.basic;

import java.util.HashMap;
import java.util.Map;

public class LongestSumK {
    public int lengthOfLongestSumK(int []arr, int k){
        Map<Integer, Integer>mp=new HashMap<>();
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<arr.length;i++){
            mp.put(arr[i], i);
        }
        int length=0;
        for (int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i]-k)){
                int len =i-mp.get(arr[i]-k);
                if(len>length)length=len;
            }

        }
        return length;
    }
}
