package sort;

import org.junit.Test;

public class QuickSort {

    @Test
    public void canQuickSort() {
        int[] array = {5, 6, 3, 7, 9, 1};
        quickSort(array, 0, 5);
        for (int elem : array) {
            System.out.println(elem + " ");
        }
    }


    private void quickSort(int[] arr, int start, int end) {
        if (start > end) return;

        int pIndex = randomizedPartition(arr, start, end);
        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }

    private int randomizedPartition(int[] arr, int start, int end){
        int pIndex = (int) (Math.random()*(end-start)+start);
        swap(arr, pIndex, end);
        return partition(arr, start, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int index = start; index < end; index++) {
            if (arr[index] <= pivot) {
                swap(arr, index, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
