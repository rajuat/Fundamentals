package hackerrank;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/migratory-birds/problem
public class MigratoryBird {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        scanner.close();
    }

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
        int firstType = ar[0];
        int lastType = ar[ar.length - 1];
        int[] countOfEachType = new int[lastType - firstType + 1];
        int typeIndex = 0;
        for(int birdType = firstType; birdType <= lastType; birdType++){
            countOfEachType[typeIndex++] = getSimilarBirdCount(ar, birdType);
        }
        quickSort(countOfEachType, 0, countOfEachType.length -1);
        return countOfEachType[countOfEachType.length -1];
    }

    private static int getSimilarBirdCount(int[] arr, int elem){
        return 1 + getLastOccurance(arr, elem) - getFirstOccurance(arr, elem);
    }

    private static int getFirstOccurance(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == elem) {
                result = mid;
                end = mid - 1;
            } else if(arr[mid] < elem){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int getLastOccurance(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == elem) {
                result = mid;
                start = mid + 1;
            } else if(arr[mid] < elem){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }


    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int index = start; index < end; index++) {
            if (arr[index] < pivot) {
                swap(arr, index, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] arr, int index, int pIndex) {
        int temp = arr[index];
        arr[index] = arr[pIndex];
        arr[pIndex] = temp;
    }


}
