package sort;

import org.junit.Test;

public class MergeSort {

    @Test
    public void canMergeSort(){
        int[] array = {5, 6, 3, 7, 9, 1};
        mergeSort(array);
        for(int elem: array){
            System.out.println(elem + " ");
        }
    }


    private void mergeSort(int[] arr){
        int n = arr.length;
        //base condition
        if(n < 2){
            return;
        }

        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        int index = 0;

        for(index = 0; index < mid; index++){
            left[index] = arr[index];
        }
        for(int i = 0; i < n-mid; i++ ){
            right[i] = arr[index+i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }


    private void merge(int[] left, int[] right, int[] whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                whole[wholeIndex] = left[leftIndex];
                wholeIndex++;
                leftIndex++;
            } else {
                whole[wholeIndex] = right[rightIndex];
                wholeIndex++;
                rightIndex++;
            }
        }

        while (leftIndex < left.length) {
            whole[wholeIndex] = left[leftIndex];
            wholeIndex++;
            leftIndex++;
        }
        while (rightIndex < right.length) {
            whole[wholeIndex] = right[rightIndex];
            wholeIndex++;
            rightIndex++;
        }
        left = null;
        right = null;
    }
}
