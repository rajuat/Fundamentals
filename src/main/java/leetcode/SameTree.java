package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SameTree {

    @Test
    public void canDetermineSameTree(){
        assertTrue(isSameTree(new TreeNode(1), new TreeNode(1)));
        assertFalse(isSameTree(new TreeNode(1), new TreeNode(2)));
    }


    boolean result = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;
        if (p == null && q == null) return result;
        if (p != null && q != null) {
            result = isSameTree(p.left, q.left);
            if (p.val != q.val) return false;
            result = isSameTree(p.right, q.right);
        }
        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
