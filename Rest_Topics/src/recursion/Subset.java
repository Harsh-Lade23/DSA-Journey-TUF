package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        return rec(nums,0);
    }
    private List<List<Integer>> rec(int []nums, int i ){
        List<List<Integer>> main=new ArrayList<>();
        if(i>=nums.length){
            main.add(new ArrayList<>());
            System.out.println("i = "+i+", main = "+main);
            return main;
        }
        int current=nums[i];
        List<List<Integer>> got=rec(nums, i+1 );
        System.out.println();
        System.out.println("i = "+i+", got = "+got);
        for(var ele:got){
            List<Integer> ele2=new ArrayList<>();
            main.add(ele);
            System.out.println("before add main = "+main);
            ele2=ele;
            ele2.add(current);
            main.add(ele2);
            System.out.println("after add main = "+main);

        }
        System.out.println("Loop end: i = "+i+", main = "+main);
        return main;

    }
}
