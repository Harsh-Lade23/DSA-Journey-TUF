package basic_recursion;

public class Recursion_Factorial_N {
    public int factorialOfN(int n){
        if(n==0 || n==1)return 1;
        return factorialOfN(n-1)*n;
    }
}
