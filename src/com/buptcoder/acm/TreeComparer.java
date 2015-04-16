package com.buptcoder.acm;

public class TreeComparer {
    private static boolean isSame = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        isSame = true;
        if (p == null && q == null) {
            return true;
        }
        isSameTreeRecusive(p, q);
        return isSame;
    }

    private void isSameTreeRecusive(TreeNode p, TreeNode q) {
        if (!isSame) {
            return;
        }
        if (isSameNode(p, q)) {
            if (p.left != null || q.left != null) {
                isSameTreeRecusive(p.left, q.left);
            }
            if (p.right != null || q.right != null) {
                isSameTreeRecusive(p.right, q.right);
            }
        } else {
            isSame = false;
            return;
        }
    }

    private boolean isSameNode(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val) {
            return true;
        }
        return false;
    }
}
