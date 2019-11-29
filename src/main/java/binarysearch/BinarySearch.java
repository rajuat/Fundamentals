package binarysearch;

import org.junit.Test;

public class BinarySearch {

    @Test
    public void search(){
        int[] a = {1,2,3,4,5,6,8,9};
        System.out.println("Complexity: " + search(a, 7));
    }

    @Test
    public void searchFirstOccurance(){
        int[] a = {1,2,3,4,4,4,4,5,6,8,9};
        searchFirstOccurance(a, 4);
    }

    @Test
    public void searchLastOccurance(){
        int[] a = {1,2,3,4,4,4,4,5,6,8,9};
        searchLastOccurance(a, 4);
    }

    @Test
    public void countNumberOfDuplicates(){
        int[] a = {1,2,3,4,4,4,4,5,6,8,9};
        System.out.println(searchLastOccurance(a, 4) - searchFirstOccurance(a,4) + 1);
    }

    private int searchFirstOccurance(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;
        while (high >= low) {
            int mid = (low + high) / 2;
            System.out.println("Mid: " + mid);
            if(x == arr[mid]){
                result = mid;
                high = mid -1;
            } else if (x > arr[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Found in index: " + result);
        return result;
    }

    private int searchLastOccurance(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;
        while (high >= low) {
            int mid = (low + high) / 2;
            System.out.println("Mid: " + mid);
            if(x == arr[mid]){
                result = mid;
                low = mid + 1;
            } else if (x > arr[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Found in index: " + result);
        return result;
    }

    private int search(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int count = 0;
        while (high > low) {
            count++;
            int mid = (low + high) / 2;
            System.out.println("Mid: " + mid);
            if(x == arr[mid]){
                System.out.println("Found in index: " + mid);
                break;
            } else if (x > arr[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }
}
