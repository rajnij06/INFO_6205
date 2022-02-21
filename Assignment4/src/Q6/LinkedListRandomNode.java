// https://leetcode.com/problems/linked-list-random-node/

import java.util.ArrayList;

public class LinkedListRandomNode {
//-----------------------------------Main code Start-----------------------------
    ArrayList<Integer> ans;
    int sz;
    public Solution(ListNode head) { // to run on LeetCode have changed class name from LinkedListRandomNode to Solution
        ans = new ArrayList<>();
        sz = 0;
        ListNode temp = head;
        while (temp != null) {
            ans.add(temp.val);
            temp = temp.next;
            sz++;
        }
    }
    public int getRandom() {
        int index = (int)(Math.random()*sz);
        return ans.get(index);
    }
//-----------------------------------Main code End-----------------------------
}
