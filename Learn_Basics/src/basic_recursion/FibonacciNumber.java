package basic_recursion;

public class FibonacciNumber {

    public int printFibonacciSeries(int n){

        if(n<=1){
            return n;
        }

        return printFibonacciSeries(n-1)+printFibonacciSeries(n-2);
    }
}
