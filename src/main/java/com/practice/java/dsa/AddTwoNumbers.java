package com.practice.java.dsa;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify edge cases
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // Get values from current nodes (if available)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);  // Add result digit
            current = current.next;

            if (l1 != null) l1 = l1.next;  // Move to next nodes
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;  // First node is dummy
    }

    public static void main(String[] args) {
       // Input: l1 = [2,4,3], l2 = [5,6,4]

        int[] value1 = new int[]{2,4,3};
        int[] value2 = new int[]{5,6,4};
        ListNode lNode1 =  pupulateNode(value1);
        ListNode lNode2 =  pupulateNode(value2);

       ListNode node =  addTwoNumbers(lNode1, lNode2);
        printList(node);
    }

    private static ListNode pupulateNode(int[] value1) {
        ListNode lNode = new ListNode(0);
        ListNode current = lNode;
        for (int val : value1) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return lNode;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}

