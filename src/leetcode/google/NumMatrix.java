package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NumMatrix {
    int[][] matrix = null;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void update(int row, int col, int val) {
        if(matrix.length > 0 && row < matrix.length && col < matrix[0].length) {
            matrix[row][col] = val;
        } else {
            throw new IndexOutOfBoundsException("Row or Column should be lesser than matrix size.");
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            for(int col = col1; col <= col2; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
}
