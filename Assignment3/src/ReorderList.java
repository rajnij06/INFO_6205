// https://leetcode.com/problems/reorder-list/

public class ReorderList {
    public static void main (String[] args) {
        ListNode list = new ListNode();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        reorderList(head);
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static void reorderList(ListNode head) {
        ListNode temp = head;
        ListNode mid = findMid(temp);
        ListNode rvr = reverse(mid.next);
        mid.next = null;
        mid = head;
        while (rvr != null) {
            ListNode temp1=mid.next;
            ListNode temp2=rvr.next;
            mid.next=rvr;
            rvr.next=temp1;
            mid=temp1;
            rvr=temp2;
        }
    }
    public static ListNode findMid(ListNode list) {
        ListNode fir = list;
        ListNode sec = list.next;
        while (sec != null && sec.next != null) {
            fir = fir.next;
            sec = sec.next.next;
        }
        return fir;
    }
    public static ListNode reverse(ListNode list) {
        ListNode fir = null;
        ListNode temp = list;
        while (temp != null) {
            ListNode current = temp;
            current = current.next;
            temp.next = fir;
            fir = temp;
            temp = current;
        }
        return fir;
    }
// --------------------------------------Main code Ends-----------------------------------------
}
