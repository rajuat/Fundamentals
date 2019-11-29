package algorithmchapone;

/**
 * Created by Raju on 7/21/2018.
 */
public class AddBinaryIntegers {

    int[] A = {1, 0, 1, 1, 0, 1};
    int[] B = {1, 0, 1, 1, 0, 1};
    int length = 6;

    //C is loop invariant and right now hold zeros that is the sum
    int[] C = new int[7];

    void add() {
        //C contains corrent result so far before and after each loop
        for (int i = length - 1; i > -1; i--) {
            int sum = A[i] + B[i] + C[i];
            if (sum == 2) {
                C[i] = 0;
                C[i - 1] = 1;
            } else if (sum == 3) {
                C[i] = 1;
                C[i - 1] = 1;
            } else {
                C[i] = sum;
            }
        }
    }
}
