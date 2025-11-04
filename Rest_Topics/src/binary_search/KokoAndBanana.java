package binary_search;

/**
 * Leetcode - 875. Koko Eating Bananas

 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours
 */
public class KokoAndBanana {
    public int findMax(int []arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)max=arr[i];
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=findMax(piles);
        System.out.println("max = "+max);

        int left=0, right=max;
        int k=1;
        while(left<=right){
            int mid=(left+right)/2;
            int curHr=findHrs(piles, mid);
            System.out.println("mid = "+mid+", curHr = "+curHr);
            if(curHr>h)left=mid+1;
            else{
                k=mid;
                right=mid-1;
            }
        }
        return k;
    }

    public int findHrs(int []piles, int hr){
        int sum=0;
        for(int i=0;i<piles.length;i++){
            sum+= (int) Math.ceil((double) piles[i]/(double)hr);
        }
        return sum;
    }
}
