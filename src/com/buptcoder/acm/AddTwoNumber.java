package com.buptcoder.acm;

public class AddTwoNumber {
    /**
     * Definition for singly-linked list. public class ListNode { int val;
     * ListNode next; ListNode(int x) { val = x; next = null; } }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode result = null;
        if (isOneOfNull(l1, l2)) {
            result = getNotNullOne(l1, l2);
        } else if (isBothValid(l1, l2)) {
            result = addTwoListNode(l1, l2);
        }
        return result;
    }

    private boolean isOneOfNull(ListNode l1, ListNode l2) {
        boolean result = false;
        if ((l1 == null && l2 != null) || (l2 == null && l1 != null)) {
            result = true;
        }
        return result;
    }

    private ListNode getNotNullOne(ListNode l1, ListNode l2) {
        return l1 == null ? l2 : l1;
    }

    private boolean isBothValid(ListNode l1, ListNode l2) {
        boolean result = false;
        if (l1 != null && l2 != null) {
            result = true;
        }
        return result;
    }

    private ListNode addTwoListNode(ListNode l1, ListNode l2) {
        int isPromoted = 0;
        int first = l1.val + l2.val;
        if (first >= 10) {
            isPromoted = 1;
            first = first - 10;
        }
        ListNode result = new ListNode(first);
        ListNode tmpIterator = result;
        while (l1.next != null || l2.next != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            int l1Val = l1Next != null ? l1Next.val : 0;
            int l2Val = l2Next != null ? l2Next.val : 0;
            int addVal = isPromoted + l1Val + l2Val;
            if (addVal >= 10) {
                addVal = addVal - 10;
                isPromoted = 1;
            } else {
                isPromoted = 0;
            }
            ListNode resultNext = new ListNode(addVal);
            tmpIterator.next = resultNext;
            tmpIterator = tmpIterator.next;
            if (l1Next != null) {
                l1 = l1Next;
            }
            if (l2Next != null) {
                l2 = l2Next;
            }
        }
        if (isPromoted == 1) {
            ListNode resultNext = new ListNode(isPromoted);
            tmpIterator.next = resultNext;
        }
        return result;
    }
}
