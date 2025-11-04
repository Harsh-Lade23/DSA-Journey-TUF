package backtracking;


import java.util.ArrayList;
import java.util.List;

/** Problem: Leetcode - 46. Permutations

 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations {
    public List<List<Integer>> permute(int[]arr){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> toTake=new ArrayList<>();
        for(int e: arr)toTake.add(e);
        List<Integer> taken=new ArrayList<>();
        permutes(toTake, taken, ans);
        return ans;
    }
    private void permutes(List<Integer> toTake, List<Integer>taken, List<List<Integer>>ans){
        if(toTake.isEmpty()){
            List<Integer> ls = new ArrayList<>(taken); //n operations
            ans.add(ls);
            return;
        }

        for (int i=0;i<toTake.size();i++){ //n
            int cur=toTake.get(i);
            toTake.remove(toTake.get(i));
            taken.add(cur);
            permutes(toTake, taken, ans);
            toTake.add( i, cur);
            taken.removeLast();
        }
    }
}















