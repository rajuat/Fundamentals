package sort;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void canSort(){
        int[] arr = {6, 7, 3, 2, 5, 8};
        divide(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    void divide(int[] whole) {
        int size = whole.length;
        if (size < 2) return;

        int mid = size / 2;

        int[] left = new int[mid];
        for (int i = 0; i < mid - 1; i++) {
            left[i] = whole[i];
        }
        int[] right = new int[size - mid];
        for (int j = 0; j < size - mid; j++) {
            right[j] = whole[j+mid];
        }
        divide(left);
        divide(right);
        merge(left, right, whole);
    }

    void merge(int[] left, int[] right, int[] whole) {
        int wholeIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                whole[wholeIndex] = left[leftIndex];
                leftIndex++;
                wholeIndex++;
            } else if (right[leftIndex] > right[rightIndex]) {
                whole[wholeIndex] = right[rightIndex];
                rightIndex++;
                wholeIndex++;
            }
        }
        while (leftIndex < left.length) {
            whole[wholeIndex] = left[leftIndex];
            leftIndex++;
            wholeIndex++;
        }

        while (rightIndex < right.length) {
            whole[wholeIndex] = right[rightIndex];
            rightIndex++;
            wholeIndex++;
        }
    }
}
