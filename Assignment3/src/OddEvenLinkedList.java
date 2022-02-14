// https://leetcode.com/problems/odd-even-linked-list/ *

public class OddEvenLinkedList {
    public static void main (String[] args) {
        ListNode list = new ListNode();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        printList(oddEvenList(head));
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode evenHead = head.next;
        ListNode oddHead = head;
        ListNode ehCopy = evenHead;
        ListNode ohCopy = oddHead;
        while(ehCopy != null && ehCopy.next != null){
            ohCopy.next = ehCopy.next;
            ehCopy.next = ohCopy.next.next;
            ohCopy = ohCopy.next;
            ehCopy = ehCopy.next;
        }
        ohCopy.next = evenHead;
        return oddHead;
    }
// --------------------------------------Main code Ends-----------------------------------------
    public static void printList (ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
