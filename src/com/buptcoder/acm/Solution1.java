package com.buptcoder.acm;

import java.util.Stack;

public class Solution1 {
    private static int visibleCount = 0;
    private Stack stack;
    public int solution(Tree T) {
        // write your code here...
        visibleCount = 0;
        if (T != null) {
            findSubTreeVisibleCount(T, T.x);
        }
        return visibleCount;
    }

    private void findSubTreeVisibleCount(Tree T, int maxValue) {
        if (T == null) {
            return;
        } else {
            if (T.x >= maxValue) {
                visibleCount++;
                maxValue = T.x;
            }
        }
        findSubTreeVisibleCount(T.l, maxValue);
        findSubTreeVisibleCount(T.r, maxValue);
    }

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
}
