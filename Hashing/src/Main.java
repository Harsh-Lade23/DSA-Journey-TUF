import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int[] createArray(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size: ");
        int size=sc.nextInt();
        int []arr=new int[size];
        System.out.print("Enter values: ");
        for(int i=0;i<size;i++){
            arr[i]= sc.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
       Problems b=new Problems();
       int []arr=createArray();
        System.out.println(b.lar(arr));
    }
}












