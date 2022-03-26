// https://leetcode.com/problems/linked-list-components/

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
//-----------------------------------Main code Start-----------------------------
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        int ans = 0;
        ListNode current = head;
        while (current!=null) {
            if(temp.contains(current.val)) {
                ans++;
        while(current!=null && temp.contains(current.val)) {
                    current = current.next; }}
            else current = current.next;
        }
        return ans;
    }
//-----------------------------------Main code End-----------------------------
}
