package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MostStonesRemove {

    @Test
    public void test1() {
        int[][] input = new int[100][100];
        input[0][0] = 1;
        input[0][1] = 1;
        input[1][0] = 1;
        input[1][2] = 1;
        input[2][1] = 1;
        input[2][2] = 1;
        assertEquals(5, removeStones(input));
    }

    @Test
    public void test2() {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][2] = 1;
        input[1][1] = 1;
        input[2][0] = 1;
        input[2][2] = 1;
        assertEquals(3, removeStones(input));
    }

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) return 0;
        int res = 0;
        int n = stones.length;
        int m = stones[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (stones[row][col] > 0) {
                    int k = col + 1;
                    for (; k < m; k++) {
                        if (stones[row][k] > 0) {
                            stones[row][col] = 0;
                            System.out.printf("Row: row col k, %d, %d, %d\n", row, col, k);
                            res++;
                            break;
                        }
                    }
                    if (stones[row][col] == 0) {
                        continue; //have a row cleared
                    }
                    if (!cols[col]) {
                        k = row + 1;
                        for (; k < n; k++) {
                            if (stones[k][col] > 0) {
                                stones[row][col] = 0;
                                System.out.printf("Col: row col k, %d, %d, %d\n", row, col, k);
                                res++;
                                break;
                            }
                        }
                        if (k + 1 == n) {
                            cols[col] = true;
                        }
                    }
                }
            }
        }
        return res;
    }

}
