// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class RemoveDuplicatesfromSortedListII {
    public static void main (String arg[]) {
        ListNode list = new ListNode();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(5);
        ListNode head7 = new ListNode(5);
        ListNode head = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;

        printList(deleteDuplicates(head));
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static ListNode deleteDuplicates(ListNode head) {
        if ( head == null ) return null;
        if ( head.next==null ) return head;
        ListNode main = new ListNode();
        ListNode ans = main;
        int temp=0;
        if ( head.val!=head.next.val ) {
            main.next = new ListNode(head.val);
            main = main.next; }
        while ( head.next.next != null ) {
            temp = head.val;
            head = head.next;
            if (head.val != temp && head.val != head.next.val) {
                main.next = new ListNode(head.val);
                main = main.next; }
        }
        if ( head.val!=head.next.val ) {
            main.next = new ListNode(head.next.val); }
        return ans.next;
    }
// --------------------------------------Main code Ends-----------------------------------------
    public static void printList (ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
