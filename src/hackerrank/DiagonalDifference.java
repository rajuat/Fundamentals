package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/diagonal-difference/problem
public class DiagonalDifference {


    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] a) {

        int sumDownwardDiagonal = 0;
        int sumUpwardDiagonal = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            //int[] arow = a[i];
            for (int j = 0; j < n; j++) {
                if(i == j){
                    sumDownwardDiagonal += a[i][j];
                }  if( i + j == n-1){
                    sumUpwardDiagonal += a[i][j];
                }
            }
        }

        System.out.println(sumDownwardDiagonal + " " + sumUpwardDiagonal);
        if(sumDownwardDiagonal > sumUpwardDiagonal){
            return sumDownwardDiagonal - sumUpwardDiagonal;
        } else {
            return sumUpwardDiagonal - sumDownwardDiagonal;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int aItem = Integer.parseInt(aRowItems[j]);
                a[i][j] = aItem;
            }
        }

        int result = diagonalDifference(a);


        scanner.close();
    }
}


