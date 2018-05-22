package sort;

import org.junit.Test;

public class BubbleSort {

    @Test
    public void canBubbleSort(){
        int[] array = {5, 6, 3, 7, 9, 1};
        int count = sort(array);
        System.out.println("Count: " + count);
        for(int elem: array){
            System.out.println(elem + ", ");
        }
    }

    private int sort(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length - i; j++ ){
                count++;
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return count;
    }
}
