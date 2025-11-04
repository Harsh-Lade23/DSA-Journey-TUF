package basic_maths;

/**
 * You are given an integer n.
 * You need to check whether it is an armstrong number or not.
 * Return true if it is an armstrong number, otherwise return false.
 * An armstrong number is a number which is equal to the sum of the digits of the number,
 * raised to the power of the number of digits.
 */


public class ArmstrongNumber {
    public boolean checkArmstrong(int n){
        int sum=0;
        int dup=n;
        int digNum=0;
        while (dup>0){
            digNum++;
            dup=dup/10;
        }
        dup=n;
        while (dup>0){
            int lastDig=dup%10;
            int pow=1;
            for(int i=0;i<digNum;i++){
                pow=pow*lastDig;
            }
            sum+=pow;
            dup/=10;
        }
        return sum==n;

    }

}
