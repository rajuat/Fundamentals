package binarysearch;

import org.junit.Test;

public class BinaryrecursionSearch {


    @Test
    public void search(){
        int[] a = {1,2,3,4,5,6,8,9};
        search(a, 0, a.length, 8);
    }

    private void search(int[] arr, int start, int end, int x){
        System.out.println("loop");
        if(start > end) return;

        int mid = (start + end) / 2;
        if(x == arr[mid]){
            System.out.println("Found in index: " + mid);
            return;
        } else if(x > arr[mid]){
            search(arr, mid + 1, end, x);
        } else {
            search(arr, start, mid -1, x);
        }
    }
}
