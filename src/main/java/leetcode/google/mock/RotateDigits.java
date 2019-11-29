package leetcode.google.mock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateDigits {

    @Test
    public void test(){
        //assertEquals(4, rotatedDigits(10));
        assertEquals(16, rotatedDigits(100));

    }

    public int rotatedDigits(int N) {

        double goodNumbers = good(N, 0);
        return (int) goodNumbers;
    }

    double good(int N, double goodNumbers) {
        if (N == 0) return 0;
        int n = N;
        int digit = 1;
        while (n > 10) {
            n = n /10;
            digit++;
        }
        if (digit == 1) {
            if (N >= 9) goodNumbers += 4;
            else if (N >= 6) goodNumbers += 3;
            else if (N >= 5) goodNumbers += 2;
            else if (N >= 2) goodNumbers += 1;
            return goodNumbers;
        }
        goodNumbers += Math.pow(4, digit);
        good(N / (10 * digit), goodNumbers);
        return goodNumbers;
    }

    /*
    not allowed 3 4 7
    0 1 8
    10 - 4 (2, 5, 6, 9) = 4
    100 -   12, 15, 16, 19, (4)
            20, 21, 22, 25, 26, 28, 29, (7)
            3 (0)
            4 (0)
            5 (7)
            6 (7)
            7 (0)
            8 (4)
            9 (7)
            4*2 + 7*4 = 8 + 28 = 36
    1000 -  1 (36)
            2 (7*7) = 49;
            3 (0)
            4 (0)
            5 (49)
            6 (49)
            7 (0)
            8 (36)
            9 (49)
            36*2 + 49*4 = 484
     */
}
