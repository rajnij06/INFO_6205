// https://leetcode.com/problems/merge-in-between-linked-lists/

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class MergeInBetweenLinkedLists {
//-----------------------------------Main code Start-----------------------------
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;
        int i=0;
        while (i < a-1) {
            start = start.next;
            end = end.next;
            i++;
        }
        while (i <= b) {
            end = end.next;
            i++;
        }
        start.next = list2;
        while (list2.next != null) list2 = list2.next;
        list2.next = end;
        return list1;
    }
//-----------------------------------Main code End-----------------------------
}
