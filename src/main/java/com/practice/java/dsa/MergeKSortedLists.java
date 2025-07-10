package com.practice.java.dsa;

import java.util.*;


public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: empty input
        if (lists == null || lists.length == 0) return null;

        // Define a min-heap with a custom comparator for ListNode
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        // Initialize the heap with the head of each list
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // While the heap is not empty, pop the smallest element and move its list forward
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListUtils utils = new LinkedListUtils();
        MergeKSortedLists merger = new MergeKSortedLists();

        ListNode[] lists = new ListNode[] {
                utils.buildList(new int[]{1, 4, 5}),
                utils.buildList(new int[]{1, 3, 4}),
                utils.buildList(new int[]{2, 6})
        };

        ListNode merged = merger.mergeKLists(lists);
        utils.printList(merged);  // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
