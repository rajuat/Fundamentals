package leetcode.google;

import org.junit.Test;
import tree.TreeNode;
import tree.TreeWrapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlipEquivalentBinaryTree {

    @Test
    public void test1() {
        TreeNode root1 = TreeWrapper.stringToTreeNode("[1,2,3,4,5,6,null,null,null,7,8]");
        TreeNode root2 = TreeWrapper.stringToTreeNode("[1,3,2,null,6,4,5,null,null,null,null,8,7]");
        TreeWrapper.prettyPrintTree(root1);
        TreeWrapper.prettyPrintTree(root2);
        assertTrue(flipEquiv(root1, root2));
    }




    @Test
    public void test2() {
        TreeNode root1 = TreeWrapper.stringToTreeNode("[0,3,1,null,null,null,2]");
        TreeNode root2 = TreeWrapper.stringToTreeNode("[0,3,1,2]");
        TreeWrapper.prettyPrintTree(root1);
        TreeWrapper.prettyPrintTree(root2);
        assertFalse(flipEquiv(root1, root2));
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null  || root2 == null) return root1 == root2;
        if(root1.val != root2.val) return false;
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    boolean flip(TreeNode h1, TreeNode h2, boolean swaped) {
        if (h1 == null) return h2 == null;
        if (h2 == null) return h1 == null;
        if (h1.val == h2.val) {
            if (h1.left == null && h2.left == null) {
                return true;
            } else if (h1.left != null && h2.left != null) {
                if (h1.left.val == h2.left.val) {
                    flip(h1.left, h2.left, false);
                } else if (!swaped) {
                    invert(h1);
                    flip(h1, h2, true);
                } else {
                    return false;
                }
            } else if(!swaped){

                flip(h1, h2, true);
            } else {
                return false;
            }

            if (h1.right != null && h2.right != null) {
                if (h1.right.val == h2.right.val) {
                    flip(h1.right, h2.right, false);
                } else if (!swaped) {
                    invert(h1);
                    flip(h1, h2, true);
                } else {
                    return false;
                }
            } else if (h1.right == null && h2.right == null) {
                return true;
            } else if (!swaped){

                flip(h1, h2, true);
            } else {
                return false;
            }
        }
        return true;
    }

    int countChildren(TreeNode n) {
        int c = 0;
        c = n.left != null ? c+1 : c;
        c = n.right != null ? c+1 : c;
        return c;
    }

    void invert(TreeNode n) {
        TreeNode temp = n.left;
        n.left = n.right;
        n.right = temp;

    }
}
