package greedy;

import java.util.Arrays;


/**
 * Problem - Leetcode: 1005. Maximize Sum Of Array After K Negations
 * Given an integer array nums and an integer k, modify the array in the following way:
 * choose an index i and replace nums[i] with -nums[i].
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 * Return the largest possible sum of the array after modifying it in this way.
 */
public class MaxSumAfterKNegations {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] alph= new int[26];
        for(char ch: s.toCharArray()){
            alph[ch-'a']++;
        }

        StringBuilder ans= new StringBuilder();
        StringBuilder pq=new StringBuilder();
        for(int i=25;i>=0;i--){
            if(alph[i]>0){
                pq.append((char)('a'+i));
            }
        }
        int count=0;
        while (!pq.isEmpty()){
            if(count<repeatLimit){
                char firstchar=pq.charAt(0);
                ans.append(firstchar);
                alph[firstchar-'a']--;
                if(alph[firstchar-'a']<=0) {
                    pq.deleteCharAt(0);
                    count=0;
                }else count++;
            }
            else{
                char temp=pq.charAt(0);
                pq.deleteCharAt(0);
                if(pq.isEmpty())break;
                char lastChar=pq.charAt(0);
                ans.append(lastChar);
                alph[lastChar-'a']--;
                if(alph[lastChar-'a']<=0) {
                    pq.deleteCharAt(0);
                }
                count=0;
                pq.insert(0, temp);
            }

        }
        return ans.toString();
    }
}
