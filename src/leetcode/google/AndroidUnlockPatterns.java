package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidUnlockPatterns {
    @Test
    public void count() {
        numberOfPatterns(2, 0);
    }

    Graph g = new Graph();
    List<List<Integer>> list = new ArrayList<>();

    public int numberOfPatterns(int m, int n) {
        numbers(2);
        System.out.println("sas " + list.size());
        return 0;
    }

    void numbers(int m) {
        if (m < 1) return;
        if (m == 1) {
            for (int i = 0; i < 9; i++) {
                List<Integer> pattern = new ArrayList<>();
                pattern.add(i);
                list.add(pattern);
            }
            return;
        }
        numbers(m - 1);
        List<List<Integer>> list2 = new ArrayList<>(list);

        for (List<Integer> count : list2) {
            int last = count.get(count.size() - 1);
            Node[] adjacents = g.nodes[last].adjacents;
            for (Node adjacent : adjacents) {
                if(adjacent == count) continue;
                List<Integer> copy = new ArrayList<>(count);
                copy.add(adjacent.val);
                list.add(copy);
            }
        }

        return;
    }

    class Graph {
        Node[] nodes = new Node[9];
        Graph() {
            Node zero = new Node(0);
            Node one = new Node(1);
            Node two = new Node(2);
            Node three = new Node(3);
            Node four = new Node(4);
            Node five = new Node(5);
            Node six = new Node(6);
            Node seven = new Node(7);
            Node eight = new Node(8);

            nodes[0] = zero;
            zero.adjacents = new Node[]{one, three, four, five, seven};

            nodes[1] = one;
            one.adjacents = new Node[]{zero, two, three, four, five, six, eight};

            nodes[2] = two;
            two.adjacents = new Node[]{one, three, four, five, seven};

            nodes[3] = three;
            three.adjacents = new Node[]{zero, one, two, four, six, seven, eight};

            nodes[4] = four;
            four.adjacents = new Node[]{zero, one, two, three, five, six, seven, eight};

            nodes[5] = five;
            five.adjacents = new Node[]{zero, one, two, four, six, seven, eight};

            nodes[6] = six;
            six.adjacents = new Node[]{one, three, four, five, seven};

            nodes[7] = seven;
            seven.adjacents = new Node[]{zero, two, three, four, five, six, seven};

            nodes[8] = eight;
            eight.adjacents = new Node[]{one, three, four, five, seven};
        }
    }

    class Node {
        int val;
        Node[] adjacents;
        Node(int val) {
            this.val = val;
        }
    }
}
