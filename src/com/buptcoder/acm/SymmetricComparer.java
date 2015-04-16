package com.buptcoder.acm;

public class SymmetricComparer {
    private boolean isSysmmetric;
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        isSysmmetric = true;
        isSymmetricTreeRecusive(root.left, root.right);
        return isSysmmetric;
    }

    private void isSymmetricTreeRecusive(TreeNode p, TreeNode q) {
        if (!isSysmmetric) {
            return;
        }
        if (isSameNode(p, q)) {
            if (p.left != null || q.right != null) {
                isSymmetricTreeRecusive(p.left, q.right);
            }
            if (p.right != null || q.left != null) {
                isSymmetricTreeRecusive(p.right, q.left);
            }
        } else {
            isSysmmetric = false;
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
