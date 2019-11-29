package algorithmchapone;

/**
 * Created by Raju on 7/21/2018.
 */
public class LinearSearch {

    int[] A = {2,3,6,7,4,3};
    int index = -1;
    int search(int v){
        //loop invariant is that return type is either -1 or any index witin range
        for (int i = 0; i < A.length; i++) {
            if(v == A[i]){
                index = i;
            }
        }
        //index is invariant
        return index;
    }
}
