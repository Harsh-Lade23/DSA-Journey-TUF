import java.util.HashMap;
import java.util.Map;

public class BasicProblems {
    /**
     * Problem: Write the code to display the number with the highest number of occurrence.
     */
    public int maxOccurrence(int[] arr){
        Map<Integer, Integer> mp=new HashMap<>();

        for (int j : arr) {
            mp.merge(j, 1, Integer::sum);
        }
        int key=0;
        int value=-1;
        for(var m: mp.entrySet()){
            if(value<=m.getValue()){
                value=m.getValue();
                key=m.getKey();
            }
        }
        return key;
    }
}
