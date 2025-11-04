package basic_maths;


import java.util.ArrayList;

public class DivisorsOfNumber {
    public ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sqrt = (int)Math.sqrt((double)n);

        for(int i = 1; i <= sqrt; ++i) {
            if (n % i == 0) {
                ans.add(i);
                if (n / i != i) {
                    ans.add(n / i);
                }
            }
        }

        return ans;
    }
}
