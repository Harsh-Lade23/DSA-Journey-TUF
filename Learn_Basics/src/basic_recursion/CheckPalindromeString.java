package basic_recursion;

public class CheckPalindromeString {

    public boolean checkPalindrome(String str){
        if(str.isEmpty() || str.length()==1)return true;
        boolean isSubstringPalindrome=checkPalindrome(str.substring(1, str.length()-1));
        return isSubstringPalindrome && (str.charAt(0)==str.charAt(str.length()-1));
    }
}
