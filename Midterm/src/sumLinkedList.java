// Question 2

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 public class sumLinkedList {
     public static void main(String[] args) {
         ListNode list = new ListNode();
         ListNode l11 = new ListNode(2);
         ListNode l12 = new ListNode(4);
         ListNode l13 = new ListNode(3);
         ListNode head1 = l11;
         l11.next = l12;
         l12.next = l13;
         ListNode l21 = new ListNode(5);
         ListNode l22 = new ListNode(6);
         ListNode l23 = new ListNode(4);
         ListNode head2 = l21;
         l21.next = l22;
         l22.next = l23;
         printList(addTwoNumbers(head1, head2));
     }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // If either is empty, return other linked list
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // creating a new listnode head with 0 value
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tmp = 0;
        while(l1!=null || l2!=null || tmp!=0) {
            if(l1!=null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(tmp%10); // make sure value above 10 is handled
            p = p.next; // move the result listnode to next pointer
            tmp = tmp/10; // will have value if value is >= 10 to accomodate of carry
        }
        return head.next;
    }
     public static void printList (ListNode node) {
         while (node != null) {
             System.out.print(node.val + " ");
             node = node.next;
         }
     }
}

