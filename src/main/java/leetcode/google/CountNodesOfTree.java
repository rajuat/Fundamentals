package leetcode.google;
//Google tree
public class CountNodesOfTree {
    public int countNodes(TreeNode root) {

        TreeNode current = root;
        int left = 0;
        while (current != null) {
            current = current.left;
            left++;
        }
        current = root;
        int right = 0;
        while (current != null) {
            current = current.right;
            right++;
        }
        if (left == right) {
            return (1 << left) - 1;
        }
        left = countNodes(root.left);
        right = countNodes(root.right);
        return left + right + 1;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
