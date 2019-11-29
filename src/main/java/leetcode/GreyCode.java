package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {

    public List<Integer> grayCode(int n){
        int size = (int) Math.pow(2, n);
        List<Integer> results = new ArrayList<>(size);
        if(n == 0) {
            results.add(0);
        } else {
            int digits = 1;
            while(digits < n){
                make(digits, results);
            }
        }

        return results;
    }

    private void make(int digits, List<Integer> results) {
        if(digits == 1){
            results.add(0);
            results.add(1);
        } else {

        }
    }
}
