package ctci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreesAndGraph412 {

    @Test
    public void count(){
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(-3);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(-6);
        TreeNode i = new TreeNode(2);
        TreeNode j = new TreeNode(1);
        TreeNode k = new TreeNode(5);
        TreeNode l = new TreeNode(7);
        TreeNode m = new TreeNode(3);
        TreeNode n = new TreeNode(7);
        TreeNode o = new TreeNode(4);
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        d.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.left = i;
        e.right = j;
        f.left = l;
        f.right = m;
        g.left = n;
        g.right = o;
        j.left = p;
        j.right = q;


        int matches =countMatches(a, 15);
        assertEquals(5, matches);
    }

    private int count = 0;
    int countMatches(TreeNode root, int k) {
        List<Integer> sumForIndex = new ArrayList<>();
        dfs(root, k, sumForIndex, 0);
        return count;
    }

    void dfs(TreeNode node, int k, List<Integer> sumForIndex, int index) {
        if (node == null) return;
        int sum = node.val + (index == 0 ? 0 : sumForIndex.get(index - 1));
        sumForIndex.add(index, sum);
        if (sum == k) {
            count++;
            System.out.println("index:" + index);
        }
        dfs(node.left, k, sumForIndex, index + 1);
        dfs(node.right, k, sumForIndex, index + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}
