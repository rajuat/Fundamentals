package algorithmchapone;

import org.junit.Test;

/**
 * Created by Raju on 7/21/2018.
 */
public class BinarySearch {

    int[] A = {3, 4, 6, 8, 9, 3, 7, 4, 2};
    int val = 7;
    int index = -1;

    @Test
    public void canBinSea() {
        new MergeSort().sort(A);
        binarySearch(0, A.length - 1);
        System.out.print(index);
    }

    void binarySearch(int left, int right) {
        if (left >= right) return;
        int mid = (right - left) / 2 + left;
        if(val == A[mid]){
            index = mid;
        } else if(val < A[mid]){
            binarySearch(left, mid-1);
        } else {
            binarySearch(mid+1, right);
        }
    }

}
