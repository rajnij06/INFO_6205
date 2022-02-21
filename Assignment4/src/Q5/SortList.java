// https://leetcode.com/problems/sort-list/

import java.util.PriorityQueue;

public class SortList {
//-----------------------------------Main code Start-----------------------------
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        PriorityQueue qu = new PriorityQueue<>();
        ListNode temp = head;
        while(temp != null)
        {
            qu.add(temp.val);
            temp = temp.next;
        }
        ListNode ans= new ListNode(0);
        ListNode dum = ans;
        while(qu.size()>0)
        {
            ListNode temp2=new ListNode((Integer) qu.poll());
            dum.next=temp2;
            dum = dum.next;
        }
        return ans.next;
    }
//-----------------------------------Main code End-----------------------------
}
