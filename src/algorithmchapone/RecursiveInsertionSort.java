package algorithmchapone;

import org.junit.Test;

/**
 * Created by Raju on 7/21/2018.
 */
public class RecursiveInsertionSort {

    int N = 5;
    int[] A = {5, 4, 7, 3, 8};

    @Test
    public void canRIS() {
        recursiveInSort(1);
        for (int i : A) System.out.println(i);
    }

    void recursiveInSort(int j) {
        if (j == N - 1) return;

        int key = A[j];
        int i = j - 1;
        while (i > -1 && key < A[i]) {
            A[i + 1] = A[i];
            i--;
        }
        A[i + 1] = key;
        j = j + 1;
        recursiveInSort(j);
    }

    void sort() {
        for (int j = 1; j < N; j++) {
            int key = A[j];
            int i = j - 1;

            while (i > -1 && key < A[i]) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    @Test
    public void canInSort() {
        sort();
        for (int i : A) System.out.println(i);
    }
}
