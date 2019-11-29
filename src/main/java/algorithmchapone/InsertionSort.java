package algorithmchapone;

import org.junit.Test;

/**
 * Created by Raju on 7/21/2018.
 */
public class InsertionSort {

    int[] arr = {5, 2, 4, 6, 1, 3};

    void insertionSort() {
        for (int j = 2; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            //loop invariant is arr[0..i]
            while (i > -1 && key < arr[i]) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    void insertionBinSeaSort() {
        for (int j = 2; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            //loop invariant is arr[0..i]
            while (i > -1 && key < arr[i]) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    void reverseInsertionSort() {
        for (int j = 2; j < arr.length; j++) {
            int i = j - 1;
            //loop invariant is arr[0..i]
            int key = arr[j];
            while (i > -1 && key > arr[i]){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

    @Test
    public void testReverse(){
        reverseInsertionSort();
        for(int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void test(){
        insertionSort();
        for(int i : arr){
            System.out.println(i);
        }
    }
}
