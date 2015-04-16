package com.buptcoder.acm;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode start = head;
        ListNode end = head;
        if (head == null || head.next == null) {
            return head;
        }
        start = start.next;
        head = start;
        ListNode last = null;
        while (true) {
            ListNode tmp = start.next;
            end.next = start.next;
            start.next = end;
            if (last != null) {
                last.next = start;
            }
            last = end;
            if (tmp != null && tmp.next != null) {
                end = tmp;
                start = tmp.next;
            } else {
                break;
            }
        }
        return head;
    }
}
