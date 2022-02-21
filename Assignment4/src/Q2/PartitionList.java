// https://leetcode.com/problems/partition-list/

import java.nio.file.Watchable;

public class PartitionList {
//-----------------------------------Main code Start-----------------------------
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode headl = less;
        ListNode headm = more;
        while (head != null) {
            if (head.val < x) {
                headl.next = head;
                headl = headl.next;
            }
            else {
                headm.next = head;
                headm = headm.next;
            }
            head = head.next;
        }
        headm.next = null;
        headl.next = more.next;
        return less.next;
    }
//-----------------------------------Main code End-----------------------------
}
