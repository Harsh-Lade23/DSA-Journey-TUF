import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problems {
    /**
     * Problem: Write the code to display the number with the highest number of occurrence.
     */
    public int maxOccurrence(int[] arr){
        Map<Integer, Integer> mp=new HashMap<>();

        for (int j : arr) {
            mp.merge(j, 1, Integer::sum);
        }
        int key=0;
        int value=-1;
        for(var m: mp.entrySet()){
            if(value<=m.getValue()){
                value=m.getValue();
                key=m.getKey();
            }
        }
        return key;
    }

    public boolean isAnagram(String str1, String str2){
        if(str1.length()!=str2.length())return false;
        Map<Character, Integer> mp1= new HashMap<>();
        Map<Character, Integer> mp2= new HashMap<>();

        for(int i=0;i<str1.length();i++){
            if(mp1.containsKey(str1.charAt(i))){
                mp1.put(str1.charAt(i), mp1.get(str1.charAt(i))+1);
            }
            else{
                mp1.put(str1.charAt(i), 1);
            }

            if(mp2.containsKey(str2.charAt(i))){
                mp2.put(str2.charAt(i), mp2.get(str2.charAt(i))+1);
            }
            else{
                mp2.put(str2.charAt(i), 1);
            }
        }

        return mp1.equals(mp2);
    }

    public boolean isIsomorphic(String str1, String str2){
        if(str1.length()!=str2.length())return false;

        Map<Character, Character> mp=new HashMap<>();

        for(int i=0;i<str1.length();i++){
            if(mp.containsKey(str1.charAt(i))){
                if(mp.get(str1.charAt(i))!=str2.charAt(i)){
                    return false;
                }
            }
            else{
                if(mp.containsValue(str2.charAt(i)))return false;//We can  use Hashset to save time complexity

                mp.put(str1.charAt(i), str2.charAt(i));
            }
        }
        return true;
    }


    public void twoSum(int []arr, int target){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(target-arr[i])){
                System.out.print(mp.get(target-arr[i])+" "+i);
                return;
            }
            mp.put(arr[i], i);
        }
        System.out.println(-1);
    }

    public int largestZeroSequence(int []arr){
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        int length =0;
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            int currentLength=0;
            if(!hs.contains(current-1)){
                currentLength++;
                while(hs.contains(current+1)){
                    currentLength++;
                    current=current+1;
                }
            }
            if(currentLength>length)length=currentLength;
        }
        return length;
    }

    public int maxNumberOnTheTable(int[] arr){
        HashSet<Integer> set= new HashSet<>();

        int length=0;
        int maxLength=0;
        for (int j : arr) {
            if (set.contains(j)) {
                set.remove(j);
                length--;
            } else {
                set.add(j);
                length++;
                if (maxLength < length) maxLength++;
            }
        }
        return maxLength;
    }


























}
