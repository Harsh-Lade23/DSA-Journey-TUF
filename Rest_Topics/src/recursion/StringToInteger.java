package recursion;


/*Problem: 8. String to Integer (atoi)

 Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

 The algorithm for myAtoi(string s) is as follows:

 Whitespace: Ignore any leading whitespace (" ").
 Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
 If no digits were read, then the result is 0.
 Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range.
  Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 Return the integer as the final result

 */
public class StringToInteger {
    private String removeZero(String s){
        while(s.charAt(0)==48){
            s=s.substring(1);
        }
        return s;
    }
    public int myAtoi(String s) {
        if(s.isEmpty())return 0;
        s=removeSpace(s);
        boolean isNegative=false;
        if(s.isEmpty())return 0;
        if(s.charAt(0)=='-') {
            isNegative = true;
            s=s.substring(1);
        }
        else if(s.charAt(0)=='+') s=s.substring(1);
        if (s.isEmpty() || !(s.charAt(0) >= 48 && s.charAt(0) <= 57)) return 0;
        System.out.println("Before removeZero = "+s);
        s=removeZero(s);
        System.out.println("After removeZero = "+s);


        int len=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57)len++;
            else break;
        }

        len=len-1;
        int mul=1;
        for(int i=0;i<len;i++)mul*=10;
        int firstLater=s.charAt(0)-48;
        long integer=(long)firstLater*mul+integer(s.substring(1),mul/10);
        if(isNegative)integer=-integer;
        if(integer<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        else if(integer>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        return (int)integer;

    }
    private String removeSpace(String s){
        if(s.charAt(0)!=' ')return s;
        s=removeSpace(s.substring(1));
        return s;
    }
    private long integer(String s, int mul){
        if(s.isEmpty() || !(s.charAt(0)>=48 && s.charAt(0)<=57))return 0;
        int firstLater=s.charAt(0)-48;
        long ret=integer(s.substring(1),mul/10);
        return (long) firstLater *mul+ret;

    }
}


















