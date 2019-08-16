package leetcode;

public class InvertBinaryTree226 {


    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /*public TreeNode flipEquiv(TreeNode root1, TreeNode root2){
        if (root1 == null) return null;

        TreeNode temp = root1.left;
        root1.left = root1.right;
        root1.right = temp;

        flipEquiv(root1.left);
        flipEquiv(root1.right);

        return root1;
    }*/


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) { val = v; }
    }
}
