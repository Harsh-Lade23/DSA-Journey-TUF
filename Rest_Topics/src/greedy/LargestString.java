package greedy;


import java.util.PriorityQueue;

/**
 * Problem: Leetcode - 2182. Construct String With Repeat Limit
 * You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row.
 * You do not have to use all characters from s.

 * Return the lexicographically largest repeatLimitedString possible.

 * A string a is lexicographically larger than a string b if in the first position where a and b differ,
 * string a has a letter that appears later in the alphabet than the corresponding letter in b.
 * If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.
 */
public class LargestString {
     void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] alph= new int[26];
        for(char ch: s.toCharArray()){
            alph[ch-'a']++;
        }
        printArray(alph);

        StringBuilder ans= new StringBuilder();
        StringBuilder pq=new StringBuilder();
        for(int i=25;i>=0;i--){
            if(alph[i]>0){
                pq.append((char)('a'+i));
            }
        }
        System.out.println(pq);
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
                char lastChar=pq.charAt(0);
                ans.append(lastChar);
                alph[lastChar-'a']--;
                if(alph[lastChar-'a']<=0) {
                    pq.deleteCharAt(0);
                }
                count=0;
                pq.insert(0, temp);
            }
            System.out.print("ans = "+ans+", count = "+count+", pq = "+pq+", a=");
            printArray(alph);
            System.out.println();
        }
        return ans.toString();
    }
}
