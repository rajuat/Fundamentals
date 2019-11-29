package algorithmchapone;

import org.junit.Test;

/**
 * Created by Raju on 7/21/2018.
 */
public class MergeSort {

    @Test
    public void canMergeSort() {
        int[] A = {5, 7, 6, 4, 8, 3, 2, 5};
        sort(A);
        for (int i : A) System.out.println(i);

    }

    void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < arr.length - mid; i++) {
            right[i] = arr[mid + i];
        }
        //fill left and right
        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    void merge(int[] left, int[] right, int[] arr) {
        int l = 0;
        int r = 0;
        int a = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[a] = left[l];
                l++;
            } else {
                arr[a] = right[r];
                r++;
            }
            a++;
        }
        while (l < left.length) {
            arr[a] = left[l];
            l++;
            a++;
        }
        while (r < right.length) {
            arr[a] = right[r];
            r++;
            a++;
        }
    }
}
