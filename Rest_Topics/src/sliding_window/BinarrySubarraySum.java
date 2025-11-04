package sliding_window;

public class BinarrySubarraySum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left=0, ans=0, right=0, n=nums.length, sum=0;
        while(right<n && left<n){
            System.out.printf("\nBefore: right = %d, left = %d, sum = %d, ans = %d\n",right,left,sum, ans);
            if(right!=n-1) {
                if (sum <= goal) {
                    sum += nums[right];
                    right++;
                } else {
                    sum -= nums[left];
                    left++;
                }
            }
            else{
                sum -= nums[left];
                left++;
            }
            if(sum==goal)ans++;
            System.out.printf("After: right = %d, left = %d, sum = %d, ans = %d\n",right,left,sum, ans);
        }
        return ans;
    }
}
