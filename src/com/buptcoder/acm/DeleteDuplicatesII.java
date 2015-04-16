package com.buptcoder.acm;

public class DeleteDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
            return head;
        }
        int indicator = head.val;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode start = preHead;
        while (head != null && head.next != null) {
            if (head.next.val == indicator) {
                while (head.val == indicator) {
                    head = head.next;
                    if (head == null) {
                        break;
                    }
                }
                start.next = head;
                if (head != null) {
                    indicator = head.val;
                }
            } else {
                start = head;
                head = head.next;
                indicator = head.val;
            }
        }
        return preHead.next;
    }
}
