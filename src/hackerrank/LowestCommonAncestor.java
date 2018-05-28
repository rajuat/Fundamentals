package hackerrank;

//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {

    static Node lca(Node root, int v1, int v2) {
        while(true){
            if(root.data < v1 && root.data < v2){
                root = root.right;
            } else if(root.data > v1 && root.data > v2){
                root = root.left;
            } else {
                return root;
            }
        }
    }

    Node lowestCommonAncestor(Node root, int v1, int v2) {
        List<Node> s1 = new ArrayList<>();
        List<Node> s2 = new ArrayList<>();

        dfs(root, v1, s1);
        dfs(root, v2, s2);

        int length = Math.min(s1.size(), s2.size());

        for (int i = 0; i < length - 1; i++) {
            if (s1.get(i) != s2.get(i)) {
                return s1.get(i - 1);
            }
        }
        return null;
    }

    void dfs(Node root, int v, List<Node> s) {
        if (root != null) {
            s.add(root);
            if (root.data == v) {
                return;
            } else if (v < root.data) {
                dfs(root.left, v, s);
            } else {
                dfs(root.right, v, s);
            }
        }
    }


}
