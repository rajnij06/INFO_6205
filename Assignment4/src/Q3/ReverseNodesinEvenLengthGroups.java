// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

import com.sun.javafx.collections.ListListenerHelper;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseNodesinEvenLengthGroups {
//-----------------------------------Main code Start-----------------------------
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode ans = new ListNode(0, head);
        ListNode current = ans;
        int i = 1;
        Deque<ListNode> deque = new LinkedList<>();
        while (current.next != null) {
            ListNode node1 = current;
            int size = i;
            while (size > 0 && node1.next != null) {
                deque.offer(node1.next);
                node1 = node1.next;
                size--;
            }
            ListNode endPoint = node1.next;
            if ((i - size)%2 == 1) {
                while (!deque.isEmpty()) {
                    current.next = deque.pollFirst();
                    current = current.next;
                }
            }
            else {
                while (!deque.isEmpty()) {
                    current.next = deque.pollLast();
                    current = current.next;
                }
                current.next = endPoint;
            }
            i++;
        }
        return ans.next;
    }
//-----------------------------------Main code End-----------------------------
}
