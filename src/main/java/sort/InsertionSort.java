package sort;

import org.junit.Test;

public class InsertionSort {

    @Test
    public void canInsertionSort(){
        int[] array = {5, 6, 3, 7, 9, 1};
        int count = sort(array);
        System.out.println("Count: " + count);
        for(int elem: array){
            System.out.println(elem + " ");
        }
    }

    private int sort(int[] arr){
        int count = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                count++;
                if(arr[j-1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] =  temp;
                }
            }
        }
        return count;
    }
}
