package arrays.hard;

import java.util.*;

public class TripletSum {



    private List<Integer> sortedList(int e1, int e2, int e3){
        List<Integer> list=new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);


        for(int i=0;i<2;i++){
            for(int j=1;j<=2-i;j++){
                if(list.get(j-1)>list.get(j)){
                    int temp=list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;

    }

    public List<List<Integer>> tripletSumZero(int []arr){

        //Optimal - n^2 with constant space.

        List<List<Integer>> ansList=new ArrayList<>();
        Arrays.sort(arr);

        int i=0;
        while(i<arr.length) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if(arr[i]+arr[left]+arr[right]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    ansList.add(list);
                    right--;
                    left++;
                    while(left<right && arr[left]==arr[left-1])left++;
                    while(left<right && arr[right]==arr[right+1])right--;
                }
                else if(arr[i]+arr[left]+arr[right]>0)right--;
                else left++;
            }

            do i++;
            while (i<arr.length && arr[i] == arr[i - 1]);
        }
        return ansList;

        //Little Optimal
/*
        HashSet<List<Integer>> ansSet=new HashSet<>();

        for (int i=0;i<arr.length-1;i++){
            HashSet<Integer> elements=new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                if(elements.contains(-(arr[j]+arr[i]))){
                    ansSet.add(sortedList(arr[i], arr[j], -(arr[i]+arr[j])));
                }
                else{
                    elements.add(arr[j]);
                }
            }
        }

        return new ArrayList<>(ansSet);


 */




        //Non Optimal
/*
        List<List<Integer>> ansList=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }


        for(int i=0;i<arr.length;i++){
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                if(arr[i]+arr[left]+arr[right]==0){
                    if(ansList.isEmpty()) {

                        ansList.add(makeList(arr[i], arr[left], arr[right]));
                    }
                    else{
                        boolean addInList=true;
                        for(var list:ansList){

                            if(list.contains(arr[i]) && list.contains(arr[left]) && list.contains(arr[right])){
                                addInList=false;
                                break;
                            }
                        }
                        if (addInList){
                            ansList.add(makeList(arr[i], arr[left], arr[right]));
                        }
                    }
                    right=arr.length-1;
                    left=left+1;
                }
                else if(arr[i]+arr[left]+arr[right]>0)right--;
                else left++;
            }

        }
        return ansList;
    }
    private List<Integer> makeList(int e1, int e2, int e3){
        List<Integer> sub = new LinkedList<>();
        sub.add(e1);
        sub.add(e2);
        sub.add(e3);
        return sub;

 */
    }
}
