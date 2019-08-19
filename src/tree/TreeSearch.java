package tree;

import org.junit.Test;
import queuearray.QueueArray;
import queuearray.QueueArrayGenerics;

public class TreeSearch {
    @Test
    public void breathFirstSearch(){
        bfs(TreeWrapper.stringToTreeNode("[1,2,3,4,5,6,7,8,9]"));
    }

    @Test
    public void depthFirstSearch(){
        dfs(TreeWrapper.stringToTreeNode("[1,2,3,4,5,6,7,8,9]"));
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    void bfs(TreeNode root) {
        if (root == null) return;
        QueueArrayGenerics<TreeNode> queue = new QueueArrayGenerics<>(20);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();
            System.out.println(current.val);
            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
    }
}
