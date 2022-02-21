// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

public class InsertintoSortedCircularLinkedList {
    public static void main (String args[]) {
//         -----1st test case
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(1);
        Node head = a;
        a.next = b;
        b.next = c;
        c.next = a;
        int insertVal = 2;
        Node ans = insert(head, insertVal);
        int i =0;
        while (ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
            if (++i>3) break;
        }
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            head.next = head;
            return new Node(insertVal);
        }
        if (head.next == null) {
            Node n = new Node(insertVal);
            n.next = head;
            head.next = n;
            return head;
        }
        int x = head.val;
        boolean isCycle = false;
        Node headCopy = head;
        while (true) {
            if (head.val < insertVal && head.next.val > insertVal) {
                break;
            }
            if (isCycle && head.val > head.next.val) break;
            head = head.next;
            if (head.val == x) isCycle = true;
        }
        Node newNode = new Node(insertVal);
        newNode.next = head.next;
        head.next = newNode;
        return headCopy;
    }
// --------------------------------------Main code Ends-----------------------------------------
}
