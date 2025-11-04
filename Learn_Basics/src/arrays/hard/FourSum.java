package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    static void printArray(int []arr){
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);
        System.out.print("Sorted ");
        printArray(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int left=j+1, right=nums.length-1;
                while(left<right){

                    System.out.println("i = "+i+", j = "+j+", left = "+left+", right = "+right);
                    System.out.println("Target: "+(nums[i]+nums[j]+nums[left]+nums[right]));
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        System.out.println("Adding");
                        List<Integer> ls=new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[left]);
                        ls.add(nums[right]);
                        left++;
                        right--;
                        ans.add(ls);
                        System.out.println("After adding: left = "+left+", right = "+right);
                        while(right>left && nums[left]==nums[left-1])left++;
                        while(left<right && nums[right]==nums[right-1])right--;
                        System.out.println("After adding After loop: left = "+left+", right = "+right);
                    }
                    else if(nums[i]+nums[j]+nums[left]+nums[right]>target)right--;
                    else left++;
                }
                System.out.println();
            }
            System.out.println();
        }
        return ans;
    }
}
