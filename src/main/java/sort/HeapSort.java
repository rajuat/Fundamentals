package sort;

import org.junit.Test;

public class HeapSort {

    /**
     * 1. create max heap from the array
     * 2. swap the first and last, and redude the array by 1 from last
     * 3. repeat until heap size is greater than 1
     */


    @Test
    public void canHeapSort(){
        int[] array = {5, 6, 3, 7, 9, 1};
        heapSort(array);
        for (int elem : array) {
            System.out.println(elem + " ");
        }
    }

    private void heapSort(int[] arr){
        int length = arr.length;
        for(int i = length/2 - 1; i >= 0; i--){
            heapify(arr, length, i);
        }
        for(int i = length -1; i >= 0; i--){
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int size, int index) {

        int highest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && arr[left] > arr[highest]) {
            highest = left;
        }

        if(right < size && arr[right] > arr[highest]){
            highest = right;
        }

        if(index != highest){
            int swap = arr[index];
            arr[index] = arr[highest];
            arr[highest] = swap;
            heapify(arr, size, highest);
        }
    }
}


