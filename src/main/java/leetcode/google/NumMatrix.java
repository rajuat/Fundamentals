package leetcode.google;

public class NumMatrix {
    int[][] matrix = null;
    int[][] copy = null;
    int n = 0;
    int m = 0;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0) return;
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
        copy = new int [n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            copy[i][1] = copy[i-1][1] + matrix[i-1][0];
        }
        for(int j = 1; j <= m; j++) {
            copy[1][j] = copy[1][j-1] + matrix[0][j-1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++){
                copy[i][j] = copy[i-1][j] + copy[i][j-1] - copy[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        return copy[row2+1][col2+1] - copy[row1][col2+1] - copy[row2+1][col1] + copy[row1][col1];
    }

    public void update(int row, int col, int val) {
        if(n > 0 && row < n && col < m) {
            int old = this.matrix[row][col];
            matrix[row][col] = val;
            int delta = val - old;
            for(int i = row + 1; i <= n; i++){
                for(int j = col + 1;  j <= m; j++) {
                    copy[i][j] = copy[i][j] + delta;
                }
            }
        }
    }
}
