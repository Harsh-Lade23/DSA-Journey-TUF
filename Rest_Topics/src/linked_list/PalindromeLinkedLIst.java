package linked_list;


public class PalindromeLinkedLIst {
    LLFunctions ll =new LLFunctions();

    private ListNode reverse(ListNode head){
        System.out.println("\nReverse: ");
        ListNode prev=null;
        ListNode temp=head;
        System.out.print("\nhead: ");
        ll.printList(head);
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }

        System.out.print("\nprev: ");
        ll.printList(prev);
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head.next==null)return true;
        ListNode slow=head;
        ListNode fast=head;
        System.out.println("slow = "+slow.val);

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        System.out.print("\nslow: ");
        ll.printList(slow);
        slow.next=reverse(slow.next);
        System.out.print("\nslow: ");
        ll.printList(slow);
        System.out.println("slow = "+slow.val);
        slow=slow.next;
        System.out.print("\nfast: ");
        ll.printList(fast);
        fast=head;


        while(slow!=null){
            if(slow.val!=fast.val)return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}
