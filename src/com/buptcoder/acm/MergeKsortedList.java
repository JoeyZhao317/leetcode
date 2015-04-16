package com.buptcoder.acm;

import java.util.ArrayList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class MergeKsortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = lists.size();
        if(size == 0) {
            return null;
        }
        if(size == 1) {
            return lists.get(0);
        }
        ListNode[] nodes = new ListNode[size];
        boolean[] isOver = new boolean[size];
 
        for(int i = 0; i < size; i++) {
            nodes[i] = lists.get(i);
        }
        for(int i = 0; i < size; i++) {
            if(nodes[i] != null) {
               isOver[i] = false;
            } else {
               isOver[i] = true;
            }
        }
        if(isAllDone(isOver)) {
            return null;
        }     
        int first = getMinIndex(nodes);
        ListNode head = nodes[first];
        nodes[first] = nodes[first].next;
        if(nodes[first] == null ) {
            isOver[first] = true;
        }
        ListNode head_tmp = head;
        
        while(isAllDone(isOver)) {
            int max_list = getMinIndex(nodes);
            head.next = nodes[max_list];
            head = head.next;
            nodes[max_list] = nodes[max_list].next;
            if(nodes[max_list] == null ) {
                isOver[max_list] = true;
            }
        }
        return head_tmp;
    }

    private int getMinIndex(ListNode[] nodes) {
        int min_index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && nodes[i].val < min) {
                min = nodes[i].val;
                min_index = i;
            }
        }
        return min_index;
    }

    private boolean isAllDone(boolean[] isOver) {
        boolean result = true;
        for (boolean b : isOver) {
            if (!b) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(null);
        ListNode node = new ListNode(1);
        list.add(node);
        MergeKsortedList o = new MergeKsortedList();
        o.mergeKLists(list);
    }
}