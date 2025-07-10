package com.practice.java.dsa;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node
        second.next = second.next.next;

        return dummy.next;  // Return the updated head
    }

    public static void main(String[] args) {
        LinkedListUtils utils = new LinkedListUtils();
        RemoveNthNode remover = new RemoveNthNode();

        ListNode head1 = utils.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = remover.removeNthFromEnd(head1, 2);
        utils.printList(result1);  // Output: 1 -> 2 -> 3 -> 5

        ListNode head2 = utils.buildList(new int[]{1});
        ListNode result2 = remover.removeNthFromEnd(head2, 1);
        utils.printList(result2);  // Output: (empty)

        ListNode head3 = utils.buildList(new int[]{1, 2});
        ListNode result3 = remover.removeNthFromEnd(head3, 1);
        utils.printList(result3);  // Output: 1
    }
}

