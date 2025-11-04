package basic_recursion;

public class Print_N_Numbers {
    public void print_1_to_N(int n){
        if(n==0)return;
        print_1_to_N(n-1);
        System.out.print(n+" ");
    }
    public void print_N_to_1(int n){
        if(n==0)return;
        System.out.print(n+" ");
        print_N_to_1(n-1);
    }
}
