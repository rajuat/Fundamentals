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


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p != null && q == null) return false;
        if (p == null && q != null) return false;
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            isSameTree(p.left, q.left);
            if (p.val != q.val) return false;
            isSameTree(p.right, q.right);
        }
        return true;
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
