package com.buptcoder.acm;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head1 = l1, head2 = l2, head, headtmp;
        if (head1.val < head2.val) {
            headtmp = head1;
            head1 = head1.next;
        } else {
            headtmp = head2;
            head2 = head2.next;
        }
        head = headtmp;
        while (head1 != null && head2 != null) {
            System.out.println("11");
            if (head1.val < head2.val) {
                headtmp.next = head1;
                headtmp = headtmp.next;
                head1 = head1.next;
            } else {
                headtmp.next = head2;
                headtmp = headtmp.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            headtmp.next = head2;
        } else {
            headtmp.next = head1;
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);
        MergeSortedList o = new MergeSortedList();
        ListNode head = o.mergeTwoLists(head1, head2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
