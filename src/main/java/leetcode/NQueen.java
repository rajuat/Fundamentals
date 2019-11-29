package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    @Test
    public void solve(){
        List<List<String>> solutions = solveNQueen(4);
        for(List<String> solution: solutions){
            for(String eachSolution: solution){
                System.out.println(eachSolution);
            }
            System.out.println("***************");
        }
    }

    //Production code
    private int n = 0;
    private int[] cols;
    private int[] queens;
    private int[] hills;
    private int[] dales;
    private List<List<String>> outcome = null;

    List<List<String>> solveNQueen(int n) {
        this.n = n;
        this.queens = new int[n];
        this.cols = new int[n];
        this.hills = new int[2 * n - 1];
        this.dales = new int[2 * n - 1];
        outcome = new ArrayList<>();
        backtrack(0);
        return outcome;
    }

    void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) {
                    addSolution();
                } else {
                    backtrack(row + 1);
                }
                //backtracking
                removeQueen(row, col);
            }
        }
    }

    boolean isNotUnderAttack(int row, int col) {
        int result = queens[row] + cols[col] + hills[row - col + n - 1] + dales[row + col];
        return result == 0;
    }


    void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = 1;
        hills[row - col + n - 1] = 1;
        dales[row + col] = 1;
    }

    void removeQueen(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        hills[row - col + n - 1] = 0;
        dales[row + col] = 0;
    }

    void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int row = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < row; j++){
                sb.append(" - ");
            }
            sb.append('Q');
            for(int k = row+1; k < n; k++){
                sb.append(" - ");
            }
            solution.add(sb.toString());
        }
        outcome.add(solution);
    }
}
