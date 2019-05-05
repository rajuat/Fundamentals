package techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        CandidateCode candidateCode = new CandidateCode();
        for (int i = 0; i < testCases; i++) {
            int noOfNeighbours = scanner.nextInt();
            int[] neighbours = candidateCode.createNeighbours(noOfNeighbours);

            List<Integer> evenNeighbours = new ArrayList<Integer>();
            List<Integer> oddNeighbours = new ArrayList<Integer>();

            int evenStartIndex, oddStartIndex;
            if (noOfNeighbours % 2 == 0) {
                evenStartIndex = noOfNeighbours - 2;
                oddStartIndex = noOfNeighbours - 1;
            } else {
                evenStartIndex = noOfNeighbours - 1;
                oddStartIndex = noOfNeighbours - 2;
            }

            int evenSum = candidateCode.createMaximizedEvenNeighbours(neighbours, evenNeighbours, evenStartIndex);

            int oddSum = candidateCode.createMaximizedOddNeighbours(neighbours, oddNeighbours, oddStartIndex);

            candidateCode.print(evenNeighbours, oddNeighbours, evenSum, oddSum);
        }
    }

    private int[] createNeighbours(int noOfNeighbours) {
        int[] neighbours = new int[noOfNeighbours];
        for (int j = 0; j < noOfNeighbours; j++) {
            neighbours[j] = scanner.nextInt();
        }
        return neighbours;
    }

    private int createMaximizedEvenNeighbours(int[] neighbours, List<Integer> evenNeighbours, int evenStartIndex) {
        int evenSum = 0;
        for (int evenIndex = evenStartIndex, index = 0; evenIndex >= 0; evenIndex = evenIndex - 2, index++) {
            if (neighbours[evenIndex] > 0) {
                evenNeighbours.add(neighbours[evenIndex]);
                evenSum += neighbours[evenIndex];
            }
        }
        return evenSum;
    }

    private int createMaximizedOddNeighbours(int[] neighbours, List<Integer> oddNeighbours, int oddStartIndex) {
        int oddSum = 0;
        for (int oddIndex = oddStartIndex, index = 0; oddIndex > 0; oddIndex = oddIndex - 2, index++) {
            if (neighbours[oddIndex] > 0) {
                oddNeighbours.add(neighbours[oddIndex]);
                oddSum += neighbours[oddIndex];
            }
        }
        return oddSum;
    }


    private void print(List<Integer> evenNeighbours, List<Integer> oddNeighbours, int evenSum, int oddSum) {
        if (evenSum > oddSum) {
            printArray(evenNeighbours);
        } else if (oddSum > evenSum) {
            printArray(oddNeighbours);
        } else {
            if (evenNeighbours.get(0) > oddNeighbours.get(0)) {
                printArray(evenNeighbours);
            } else {
                printArray(oddNeighbours);
            }
        }
    }

    private void printArray(List<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
