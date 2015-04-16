package com.buptcoder.acm;

public class RemoveNthNode {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if (head == null) {
                return head;
            }
            ListNode node1 = head, node2 = head;
            ListNode preNode = node2;
            int i = 0;
            while (node1.next != null) {
                i++;
                if (i >= n) {
                    preNode = node2;
                    node2 = node2.next;
                }
                node1 = node1.next;
            }
            if (node2 == head && n == 1) {
                head = null;
            } else if (node2 == head && n > 1) {
                head = head.next;
            } else if (n == 1) {
                preNode.next = null;
            } else {
                preNode.next = node2.next;
            }
            return head;
        }
    }
    
        public boolean isValid(String s) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if(s == null || s.length() == 0) {
                return true;
            }
            final int LEFT_1 = 1;
            final int LEFT_2 = 2;
            final int LEFT_3 = 3;
            int count = s.length();
            int [] map = new int[count];
            int n = 0;
            for(int i = 0; i < count; i++) {
                char tmp = s.charAt(i);
                switch(tmp) {
                    case '(':
                        map[n++] = LEFT_1;
                        break;
                    case '[':
                        map[n++] = LEFT_2;
                        break;
                    case '{':
                        map[n++] = LEFT_3;
                        break;
                    case ')':
                        if(n <= 0 || map[--n] != LEFT_1){
                            return false;
                        }
                        break;
                    case ']':
                        if(n <= 0 || map[--n] != LEFT_2) {
                            return false;
                        }
                        break;
                    case '}':
                        if(n <= 0 || map[--n] != LEFT_3 ) {
                            return false;
                        }
                        break;
                }
            }
            if( n == 0) {
                return true;
            } else {
                return false;
            }
        }
}
