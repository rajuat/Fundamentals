package leetcode.google;

import org.junit.Test;

import java.util.Arrays;

public class RotateImage {

    @Test
    public void test1() {
        int[][] image = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(image);
        for (int[] img : image) System.out.println(Arrays.toString(img));
    }

    void rotate(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i -1; j++) {
                int t = A[i][j];
                A[i][j] = A[n - 1 - j][i];
                A[n - 1 - j][i] = A[n - 1 - i][n - 1 - j];
                A[n - 1 - i][n - 1 - j] = A[j][n - 1 - i];
                A[j][n - 1 - i] = t;
            }
        }
    }
}
