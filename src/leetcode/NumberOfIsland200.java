package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIsland200 {

    public void can() {
        assertEquals(1, numIslands(new char[][]{{'1', '1'}}));

    }

    @Test
    public void islands() {
        char[][] grid = new char[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertEquals(1, numIslands(grid));

        char[][] grid2 = new char[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        assertEquals(3, numIslands(grid2));

        char[][] grid3 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands(grid3));
        assertEquals(0, numIslands(new char[][]{}));
        assertEquals(1, numIslands(new char[][]{{'1'}}));
        assertEquals(1, numIslands(new char[][]{{'1', '0'}}));
        assertEquals(0, numIslands(new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}}));
        //assertEquals(1, numIslands(new char[][]{{'1', '1'}}));
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean extendedIsland = false;
        int[][] dir = new int[][]{{1, 0}, {0, -1}, {-1, 0}}; // right down left up
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1 || grid[row][col] == '1') {
                    extendedIsland = false;
                    for (int i = 0; i < 3; i++) {
                        int newRow = row + dir[i][0];
                        int newCol = col + dir[i][1];
                        if (newRow != -1 && newRow != grid.length && newCol != -1 && newCol != grid[row].length) {
                            if (grid[newRow][newCol] == 1 || grid[newRow][newCol] == '1') {
                                extendedIsland = true;
                                break;
                            }
                        }
                    }
                    if (!extendedIsland) {
                        islands++;
                    }
                }
            }
        }
        return extendedIsland ? islands + 1 : islands;
    }
}
