package com.buptcoder.acm;

public class RemoveDuplicatedNode {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
            return head;
        }
        int lastValue = head.val;
        ListNode node = head.next;
        ListNode lastNode = head;
        while (node != null) {
            int current = node.val;
            if (current == lastValue) {
                lastNode.next = node.next;
                node = lastNode.next;
            } else {
                lastValue = node.val;
                lastNode = node;
                node = node.next;
            }
        }
        return head;
    }

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) {
            return 0;
        }
        int length = A.length;
        if (length <= 2) {
            return length;
        }
        int index = 1;
        int duplicated = 1;
        int lastValue = A[0];
        int realLength = length;

        for (int i = 1; i < length; i++) {
            int tmp = A[i];
            if (tmp == lastValue && duplicated >= 2) {
                realLength--;
            } else {
                if (tmp == lastValue) {
                    duplicated++;
                } else {
                    lastValue = A[i];
                    duplicated = 1;
                }
                A[index] = A[i];
                index++;
            }
        }
        return realLength;
    }
}
