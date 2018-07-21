package algorithmchapone;

import org.junit.Test;

/**
 * Created by Raju on 7/21/2018.
 */
public class Excercise2_3_7 {

    @Test public void canFind(){
        findMatchesForSum(9);
    }
    int[] A = {3, 4, 6, 8, 9, 3, 7, 4, 2};

    //2 3 4 4 6 7 8 9
    void findMatchesForSum(int s) {
        new MergeSort().sort(A);
        int right = A.length-1;
        int left = 0;

        while (s < A[right]) right--;
        while (s < A[left] + A[right]) right--;
        while (s > A[left] + A[right]) left++;
        if(s == A[left] + A[right]){
            System.out.print(left + " " + right);
        }
    }
}
