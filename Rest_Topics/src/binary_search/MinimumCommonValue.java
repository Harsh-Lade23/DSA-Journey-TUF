package binary_search;

/** Problem - Leetcode: 2540. Minimum Common Value

 *Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 *return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
 *
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
 */
public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        if(m>n){
            for(int i=0;i<n;i++){
                int left=0, right=m-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(nums1[mid]==nums2[i])return nums1[mid];
                    else if(nums1[mid]>nums2[i])right=mid-1;
                    else left=mid+1;
                }
            }
        }
        else{
            for(int i=0;i<m;i++){
                int left=0, right=n-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(nums2[mid]==nums1[i]) {
                            return nums1[i];
                    }
                    else if(nums2[mid]>nums1[i])right=mid-1;
                    else left=mid+1;
                }
            }
        }
        return -1;
    }
}
