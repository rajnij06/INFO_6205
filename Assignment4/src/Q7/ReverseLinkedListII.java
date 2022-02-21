// https://leetcode.com/problems/reverse-linked-list-ii/

public class ReverseLinkedListII {
//-----------------------------------Main code Start-----------------------------
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp, current;
        ListNode copy = null;
        if(left == 1) {
            copy = new ListNode(-1);
            copy.next = head;
            head = copy;
        }
        ListNode temp1 = head;
        for(int i = 1; i < left - 1; i++) {
            temp1 = temp1.next;
        }
        current = temp1.next;
        while(current != null && left < right) {
            temp = current.next;
            current.next = temp.next;
            temp.next = temp1.next;
            temp1.next = temp;
            left++;
        }
        if(copy != null) head = copy.next;
        return head;
    }
//-----------------------------------Main code End-----------------------------
}
