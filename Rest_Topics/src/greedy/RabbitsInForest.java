package greedy;


import java.util.HashMap;

/**
 * Problem: Leetcode - 781. Rabbits in Forest
 * There is a forest with an unknown number of rabbits.
 * We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

 * Given the array answers, return the minimum number of rabbits that could be in the forest.
 */
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i: answers){
            if(mp.containsKey(i)){
                mp.put(i, mp.get(i)+1);
            }
            else{
                mp.put(i, 1);
            }
        }
        int rats=0;

        for (int key : mp.keySet()) {
            int groupSize = key + 1;
            int count = mp.get(key);
            int groups = (count + groupSize - 1) / groupSize;
            rats += groups * groupSize;
        }
        return rats;

    }

}
