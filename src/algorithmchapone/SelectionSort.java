package algorithmchapone;

import org.junit.Test;

/**
 * Created by Raju on 7/21/2018.
 */
public class SelectionSort {

    int[] A = {2, 4, 7, 4, 2, 1};

    @Test
    public void canSelectionSort(){
        selectionSort();
        for(int i: A) System.out.println(i);
    }

    void selectionSort() {
        //loop invariant? Array until j-1 is sorted
        for(int j = 0; j < A.length -1; j++) {//c1 n-1
            //aray until j-1 is sorted
            for (int i = j + 1; i < A.length; i++) { //c2 Tj(time it takes for each J) summation from j+1 to n that gives n(n+1)/2
                if (A[j] > A[i]) { //c3 1
                    swap(j,i); // c4 1
                }
            }
            //aray until j-1 is sorted
        }
    }

    void swap(int j, int i){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
