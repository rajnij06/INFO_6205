import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class seach {
    public static void main (String[] args) {
        ListNode list = new ListNode();
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(2);
        ListNode head1 = l11;
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(5);
        ListNode head2 = l21;
        l21.next = l22;
        l22.next = l23;

        printList(addTwoNumbers(head1, head2));
    }
    // --------------------------------------Main code Starts-----------------------------------------
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode temp = null;
        ListNode prev = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry+(l1 == null?0:l1.val) + (l2 == null?0:l2.val);
            carry = (sum>9?1:0);
            sum = sum%10;
            temp = new ListNode(sum);
            if (res == null) res = temp;
            else prev.next = temp;
            prev = temp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) temp.next = new ListNode(carry);
        return res;
    }
    public static void printList (ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
