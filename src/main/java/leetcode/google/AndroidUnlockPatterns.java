package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AndroidUnlockPatterns {

    @Test
    public void count() {
        assertEquals(test(2,3), numberOfPatterns(2, 3));
        //assertEquals(385, numberOfPatterns(1, 3));
    }

    public int test(int m, int n) {
        int[] arr = {9,56,320,1624,7152, 26016,72912,140704,140704};
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += arr[i - 1];
        }
        return sum;
    }

    private boolean used[] = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++) {
            res += calcPatterns(-1, len);
            for (int i = 0; i < 9; i++) {
                used[i] = false;
            }
        }
        return res;
    }

    private boolean isValid(int index, int last) {
        if (used[index])
            return false;
        // first digit of the pattern
        if (last == -1)
            return true;
        // knight moves or adjacent cells (in a row or in a column)
        if ((index + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (index + last)/2;
        if (mid == 4)
            return used[mid];
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((index%3 != last%3) && (index/3 != last/3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }

    private int calcPatterns(int last, int len) {
        if (len == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last)) {
                used[i] = true;
                sum += calcPatterns(i, len - 1);
                used[i] = false;
            }
        }
        return sum;
    }

    // No of pattern trying to solve mathematically using counting problems
    public int numberOfPatternsWithPermutations(int m, int n) {
        int sum = 0;
        int[] facs = factorial(9);
        for (int i = m; i <= n; i++) {
            int permutation = (facs[9] / (facs[9 - i]));
            if (i == 2) {
                permutation -= 16;
            }
            sum += permutation;
        }
        return sum;
    }

    int[] factorial(int n) {
        int[] facs = new int[n + 1];
        facs[0] = 1;
        for (int i = 1; i <= n; i++) {
            facs[i] = i * facs[i - 1];
        }
        return facs;
    }


    //patterns with graph and other data structures
    Graph g = new Graph();
    List<List<Integer>> list = new ArrayList<>();

    public int numberOfPatternsWithGraphs(int m, int n) {
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
                if (adjacent == count) continue;
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
