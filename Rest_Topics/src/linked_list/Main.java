package linked_list;

public class Main {

    public static void main(String[] args) {
//        ListNode n4=new ListNode(1);
//        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2);
        ListNode n1=new ListNode(1,n2);
        PalindromeLinkedLIst pd= new PalindromeLinkedLIst();
        System.out.println(pd.isPalindrome(n1));
    }
}
