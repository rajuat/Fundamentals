package hackerrank;
//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
public class BinarySearchTreeInsertion {

    static Node insert(Node root,int value) {
        Node cursor = root;
        Node parent = null;
        while(cursor != null) {
            parent = cursor;
            if (value < cursor.data) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }

        Node n = new Node();
        n.data = value;

        if(value < parent.data){
            parent.left = n;
        } else {
            parent.right = n;
        }

        return root;
    }

}
