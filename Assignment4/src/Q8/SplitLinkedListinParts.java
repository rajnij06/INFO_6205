// https://leetcode.com/problems/split-linked-list-in-parts/

public class SplitLinkedListinParts {
//-----------------------------------Main code Start-----------------------------
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int i = size / k;
        int j = size % k;
        ListNode[] ans = new ListNode[k];
        temp = head;
        ListNode prev = null;
        int arrit = 0;
        int tSize = 0;
        while (temp != null) {
            if (tSize == 0) {
                if(prev != null) prev.next = null;
                tSize = i;
                if (j > 0) {
                    tSize++;
                    j--;
                }
                ans[arrit++] = temp;
            }
            prev = temp;
            temp = temp.next;
            tSize--;
        }
        return ans;
    }
//-----------------------------------Main code End-----------------------------
}
