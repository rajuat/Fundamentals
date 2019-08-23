package leetcode.google;

import com.sun.source.tree.Tree;
import org.junit.Test;
import tree.TreeNode;
import tree.TreeWrapper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class BinaryTreeDiameter {

    @Test
    public void test1() {
        TreeNode root = TreeWrapper.stringToTreeNode("[1,2,3,4,5,6,7,8,9]");
        assertEquals(5, diameterOfBinaryTree(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeWrapper.stringToTreeNode("[1,2,3,4,5]");
        assertEquals(3, diameterOfBinaryTree(root));
    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        int mm = Math.max(L, R) + 1;
        return mm;
    }





    ////////////////////
    public int diameterOfBinaryTree1(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        height(root, root, map, 0);
        List<Map.Entry<TreeNode, Integer>> entryList = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> entry.getValue().intValue())).collect(Collectors.toList());
        System.out.println(entryList);
        int max = 0;
        for (int i = 0; i < entryList.size() - 2; i++) {
            TreeNode a = entryList.get(i).getKey();
            TreeNode b = entryList.get(i + 1).getKey();
            TreeNode lca = null;
            int level = lowestCommonAncester(root, a, b, lca, 0);
            int distance = entryList.get(i).getValue() + entryList.get(i + 1).getValue() - 1;
            if (level == 0) {
                return Math.max(max, distance);
            } else {
                max = Math.max(max, distance - 2 * level);
            }
        }
        return max;
    }

    int lowestCommonAncester(TreeNode root, TreeNode a, TreeNode b, TreeNode ans, int len) {
        if (root == null || root == a || root == b) {
            return len;
        }
        boolean left = found(root.left, a);
        boolean right = found(root.right, b);
        if (left == right){
            ans = root;
            return len;
        } else {
            lowestCommonAncester(root.left, a, b, ans, len +1);
            lowestCommonAncester(root.right, a, b, ans, len +1);
        }
        return len;
    }

    boolean found(TreeNode root, TreeNode n) {
        if (root == null) {
            return false;
        }
        if (root == n) return true;

        boolean l = found(root.left, n);
        boolean r = found(root.right, n);

        return l || r;
    }


    void height(TreeNode node, TreeNode parent, Map<TreeNode, Integer> map, int h) {
        if (node == null) {
            map.put(parent, h);
            return;
        }
        height(node.left, node, map, h + 1);
        height(node.right, node, map, h + 1);
    }

    class NodeHeight {
        TreeNode n;
        int height;

        NodeHeight(TreeNode n, int height) {
            this.n = n;
            this.height = height;
        }
    }

    ///////////////
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
}
