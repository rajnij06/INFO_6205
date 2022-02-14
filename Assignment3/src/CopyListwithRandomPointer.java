// https://leetcode.com/problems/copy-list-with-random-pointer/

class Node {
    int val;
    Node next, random;
    Node(int x)
    { val = x; next = random = null; }
}
public class CopyListwithRandomPointer {
    public static void main (String[] args) {
        Node head1 = new Node(7);
        Node head2 = new Node(13);
        Node head3 = new Node(11);
        Node head4 = new Node(10);
        Node head5 = new Node(1);
        Node head = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        Node result = copyRandomList(head);
        print(result);
    }
// --------------------------------------Main code Starts-----------------------------------------
    public static Node copyRandomList(Node head) {
        Node current = head, temp = null;
        while (current != null) {
            temp = current.next;
            current.next = new Node(current.val);
            current.next.next = temp;
            current = temp;
        }
        current = head;
        while (current != null) {
            if (current.next != null)
                if (current.random != null)
                    current.next.random = current.random.next;
                else
                    current.next.random = current.random;
            current = current.next.next;
        }
        Node old = head, dup = head.next;
        temp = dup;
        while (old != null) {
            old.next = old.next.next;
            if (dup.next != null)
                dup.next = dup.next.next;
            old = old.next;
            dup = dup.next;
        }
        return temp;
    }
// --------------------------------------Main code Ends-----------------------------------------
    public static void print(Node head)
    {
        Node ptr = head;
        while (ptr != null) {
            System.out.println("Data = " + ptr.val
                    + ", Random = "
                    + ptr.random.val);
            ptr = ptr.next;
        }
    }
}
