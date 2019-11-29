package sort;

import org.junit.Test;

public class SelectionSort {

    @Test
    public void canInsertionSort(){
        int[] array = {5, 6, 3, 7, 9, 1};
        int count = selectionSort(array);
        System.out.println("Count: " + count);
        for(int elem: array){
            System.out.println(elem + " ");
        }
    }

    private int selectionSort(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length -1; i++){
            for(int j = i+1; j < arr.length; j++){
                count++;
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return count;
    }
}
