// https://leetcode.com/problems/merge-k-sorted-lists/

public class MergekSortedLists {
    public static void main (String[] args) {
        ListNode list = new ListNode();
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static ListNode mergeKLists(ListNode[] lists) {
        if ( lists.length == 0 ) return null;
        ListNode[] temp = lists;
        while( temp.length > 1 ) {
            ListNode[] current = new ListNode[(temp.length + 1) / 2];
            for(int i = 0; i < temp.length; i += 2) {
                current[i / 2] = merge(temp[i], (i + 1 >= temp.length ? null : temp[i + 1]));
            }
            temp = current;
        }
        return temp[0];
    }
    public static ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        ListNode result = new ListNode(), current = result;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        while( list1 != null || list2 != null ) {
            if(list1 == null) {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if(list2 == null) {
                current.next  = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if(list1.val <= list2.val) {
                    current.next  = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    current.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            current = current.next;
        }
        return result.next;
    }
// --------------------------------------Main code Ends-----------------------------------------
}
