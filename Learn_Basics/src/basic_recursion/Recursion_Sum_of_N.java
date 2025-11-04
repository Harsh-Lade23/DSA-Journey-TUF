package basic_recursion;

public class Recursion_Sum_of_N {
    public int sumOfN(int n){

        if(n==0)return 0;
        return n+sumOfN(n-1);
    }
}
