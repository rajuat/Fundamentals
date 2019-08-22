package leetcode.google;

import org.junit.Test;
import tree.TreeNode;
import tree.TreeWrapper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BinaryTreeDiameter {

    @Test
    public void test1() {
        TreeNode root = TreeWrapper.stringToTreeNode("[1,2,3,4,5,6,7,8,9]");
        assertEquals(5, diameter(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeWrapper.stringToTreeNode("[1,2,3,4,5]");
        assertEquals(3, diameter(root));
    }

    public int diameter(TreeNode root) {
        Map<TreeNode, Integer> startMap = new HashMap<>();
        Map<TreeNode, Integer> endMap = new HashMap<>();
        dfs(root, null, startMap, endMap);
        startMap.forEach((k, v) -> System.out.println("S Item : " + k.val + " Count : " + v));
        endMap.forEach((k, v) -> System.out.println("E Item : " + k.val + " Count : " + v));
        TreeWrapper.prettyPrintTree(root);
        return endMap.values().stream().max(Comparator.comparingInt(x -> x)).get();
    }


    private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, Integer> startMap, Map<TreeNode, Integer> endMap) {
        if (root == null) {
            startMap.put(parent, 0);
            Integer max = startMap.values().stream().max(Comparator.comparingInt(x -> x.intValue())).get();
            endMap.put(parent, max);
            return;
        }
        dfs(root.left, root, startMap, endMap);
        increment(startMap);
        dfs(root.right, root, startMap, endMap);

    }

    private void increment(Map<TreeNode, Integer> startMap) {
        for (TreeNode key : startMap.keySet()) {
            startMap.put(key, startMap.get(key) + 1);
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        NodeHeight[] heights = heightOfAllLeafs(root);

        for (int i = 0; i < heights.length - 2; i++) {
            TreeNode a = heights[i].n;
            TreeNode b = heights[i + 1].n;
            TreeNode lca = null;
            int level = lowestCommonAncester(root, a, b, lca);
            if (level == 0) {
                return heights[i].height + heights[i + 1].height - 1;
            } else {

            }
        }
        return 0;
    }

    int lowestCommonAncester(TreeNode root, TreeNode a, TreeNode b, TreeNode ans) {
        return 0;
    }

    NodeHeight[] heightOfAllLeafs(TreeNode node) {
        return null;
    }

    class NodeHeight {
        TreeNode n;
        int height;

        NodeHeight(TreeNode n, int height) {
            this.n = n;
            this.height = height;
        }
    }
}
