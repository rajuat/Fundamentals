package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumMatrixTest {
    @Test
    public void sumIt() {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        int param_2 = obj.sumRegion(2, 1, 4, 3);
        assertEquals(19, obj.sumRegion(1, 1, 4, 3));
        obj.update(3, 2, 2);
        int param_3 = obj.sumRegion(2, 1, 4, 3);
        assertEquals(8, param_2);
        assertEquals(10, param_3);
    }
}
