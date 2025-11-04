package arrays.hard;

public class MajorityElement_II {
    public int[] majorityElement(int []arr){
        int element1=Integer.MIN_VALUE;
        int element2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        for(int i=0;i<arr.length;i++){
            if(count1==0 && element2!=arr[i]){
                element1=arr[i];
                count1++;
            }
            else if(count2==0 && element1!=arr[i]){
                element2=arr[i];
                count2++;
            } else if (arr[i]==element1) {
                count1++;
            } else if (arr[i]==element2) {
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==element1)count1++;
            else if(arr[i]==element2)count2++;
        }

        int []ans=new int[2];
        if(count1>(arr.length/3))ans[0]=element1;
        if(count2>arr.length/3)ans[1]=element2;
        return ans;
    }
}
