package arrays.medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length==1)return;
        int index=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index=i-1;
                break;
            }
        }
        if(index==-1){
            int left=0;
            int right=nums.length-1;
            reverse(nums, left, right);
            return;
        }
        System.out.println("\nindex: "+index);

        int correct=index+1;
        for(int i=nums.length-1;i>index;i--){
            System.out.println("i= "+i+", correct = "+correct   );
            if(nums[i]<=nums[correct] && nums[i]>nums[index]) {
                correct=i;
            }
            System.out.println("After: i= "+i+", correct = "+correct   );

        }
        int temp=nums[index];
        nums[index]=nums[correct];
        nums[correct]=temp;

        reverse(nums, index+1, nums.length-1);



    }
    private void reverse(int []nums, int left, int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
