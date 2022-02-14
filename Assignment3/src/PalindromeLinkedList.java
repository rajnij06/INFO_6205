// https://leetcode.com/problems/palindrome-linked-list/ *

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main (String[] args) {
        ListNode list = new ListNode();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);
        ListNode head = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        System.out.println(isPalindrome(head));
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> reverseOrder = new Stack<ListNode>();
        ListNode copyHead = head;
        while(copyHead != null){
            reverseOrder.push(copyHead);
            copyHead = copyHead.next;
        }
        while(!reverseOrder.empty()){
            if(reverseOrder.pop().val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
// --------------------------------------Main code Ends-----------------------------------------
}
