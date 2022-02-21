// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

import java.util.Stack;

public class MaxTwinSumofinkedList {
//-----------------------------------Main code Start-----------------------------
    public int pairSum(ListNode head) {
        int len =0;
        ListNode temp = head;
        while (temp!=null) {
            len++;
            temp = temp.next;
        }
        int ans = Integer.MIN_VALUE;
        Stack<Integer> dum = new Stack<>();
        int i=0;
        while (i!=len/2) {
            i++;
            dum.push(head.val);
            head = head.next;
        }
        while(head!=null) {
            if((head.val+dum.peek()) > ans) ans = head.val+dum.peek();
            dum.pop();
            head = head.next;
        }
        return ans;
    }
//-----------------------------------Main code End-----------------------------
}
