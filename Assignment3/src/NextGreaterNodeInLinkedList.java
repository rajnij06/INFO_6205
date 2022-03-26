// https://leetcode.com/problems/next-greater-node-in-linked-list/

import java.util.ArrayList;

public class NextGreaterNodeInLinkedList {
// --------------------------------------Main code Starts-----------------------------------------
    public static int[] nextLargerNodes(ListNode head) {
        ListNode list = head;
        ListNode dum = null;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean flag = false;
        if( list.next != null ) dum = list.next;
        else ans.add(0);
        while( list!=null && list.next!=null ) {
            while(dum!=null) {
                if(dum.val > list.val) {
                    ans.add(dum.val);
                    flag = true;
                    break; }
                else dum = dum.next;}
            if(!flag) ans.add(0);
            flag = false;
            list = list.next;
            if( list.next != null ) dum = list.next;
            if( list == dum || dum == null )
                ans.add(0);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
// --------------------------------------Main code Ends-----------------------------------------
}
