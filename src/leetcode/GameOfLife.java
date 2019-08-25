package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameOfLife {

    @Test
    public void test1() {
        int[][] b = new int[][] {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(b);
        for(int[] a: b)
        System.out.println(Arrays.toString(a));
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (board.length == 0) return;
        int n = board[0].length;
        Set<String> changed = new HashSet<>();
        int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int[] d = dir[k];
                    int x = row + d[0];
                    int y = col + d[1];

                    if (x > -1 && x < m && y > -1 && y < n && changed.contains(x + "," + y) != (board[x][y] == 1)) {
                        count++;
                    }
                }
                if (board[row][col] == 1 && (count < 2 || count > 3)) {
                    board[row][col] = 0;
                    changed.add(row + "," + col);
                } else if (board[row][col] == 0 && count == 3){
                    board[row][col] = 1;
                    changed.add(row+","+col);
                }
            }
        }
    }
}
