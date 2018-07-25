package algorithmchapone;

import org.junit.Test;

public class Heap {

    void heapify(int[] A, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * 1 + 2;
        int lowest = i;
        if (left < heapSize && A[left] < A[i]) {
            lowest = left;
        }
        if (right < heapSize && A[right] < A[lowest]) {
            lowest = right;
        }
        if (lowest != i) {
            int temp = A[i];
            A[i] = A[lowest];
            A[lowest] = temp;
            heapify(A, lowest, heapSize);
        }
    }

    void minHeap(int[] B) {
        for (int i = B.length / 2; i > -1; i--) {
            heapify(B, i, B.length);
        }
    }

    void heapSort(int[] C) {
        minHeap(C);
        for (int i : C) System.out.print(i);
        for (int i = C.length - 1; i > -1; i--) {
            //swap C[i] and C[0]
            int lowestKey = C[i];
            C[i] = C[0];
            C[0] = lowestKey;
            //reduce heap one from right
            heapify(C, 0, i - 1);
        }
    }

    @Test
    public void canReverseSort() {
        int[] c = {3, 5, 7, 8, 2, 1, 4};
        heapSort(c);
        for (int i : c) System.out.print(i);
    }

}
