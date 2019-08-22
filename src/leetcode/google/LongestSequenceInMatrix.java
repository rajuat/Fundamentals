package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSequenceInMatrix {

    @Test
    public void test1() {
        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 5},
                {3, 2, 7, 4},
                {7, 9, 8, 5}
        };
        long l = System.nanoTime();
        assertEquals(9, longestIncreasingPathWithoutCache(input));
        System.out.println(System.nanoTime() - l);
    }

    @Test
    public void test2() {
        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 5},
                {3, 2, 7, 4},
                {7, 9, 8, 5}
        };
        long l = System.nanoTime();
        assertEquals(9, longestIncreasingPath(input));
        System.out.println(System.nanoTime() - l);
    }

    // up, right, down, left
    int[][] dir = new int[][]{
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        if (matrix == null || matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, m, n, cache));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, n, m, cache));
            }
        }
        return ++cache[i][j];
    }

    public int longestIncreasingPathWithoutCache(int[][] matrix) {
        int ans = 0;
        if (matrix == null || matrix.length == 0) return ans;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dfs = dfs(matrix, i, j, n, m);
                ans = Math.max(ans, dfs);
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m) {
        int ans = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                ans = Math.max(ans, dfs(matrix, x, y, n, m));
            }
        }
        return ++ans;
    }


}
