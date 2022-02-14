// https://leetcode.com/problems/remove-nth-node-from-end-of-list/ *

public class RemoveNthNodeFromEnd {
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
        int n=2;
        printList(removeNthFromEnd(head, n));
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        if (head.next == null && n == 1)
            return null;
        if (head.next.next == null) {
            if (n == 1) {
                head.next = null;
                return head;
            }
            else if (n == 2) {
                return head.next;
            }
        }
        int backupN = n;
        ListNode p1 = head;
        ListNode p2 = head;
        while (n != 0 && p1.next != null) {
            p1 = p1.next;
            n--;
        }
        if (p1.next == null && n > 0)
            return head.next;
        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        if (p2.next == null)
            return head;
        p2.next = p2.next.next != null ? p2.next.next : null;
        return head;
    }
// --------------------------------------Main code Ends-----------------------------------------
    public static void printList (ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
