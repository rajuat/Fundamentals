package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareRoot {

    @Test
    public void canFindSquareRootWithBinarySearch() {
        long start = System.nanoTime();
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(8));
        assertEquals(3, mySqrt(9));
        assertEquals(46340, mySqrt(2147395600));
        assertEquals(4, mySqrt(20));
        assertEquals(1, mySqrt(1));
        mySqrt(2147483647);
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void canFindSquareRootWithDivision() {
        long start = System.nanoTime();
        assertEquals(2, mySqrt2(4));
        assertEquals(2, mySqrt2(8));
        assertEquals(3, mySqrt2(9));
        assertEquals(46340, mySqrt2(2147395600));
        assertEquals(4, mySqrt2(20));
        assertEquals(1, mySqrt2(1));
        mySqrt2(2147483647);
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void canFindSquareRootWithMultiplication() {
        long start = System.nanoTime();
        assertEquals(2, mySqrt1(4));
        assertEquals(2, mySqrt1(8));
        assertEquals(3, mySqrt1(9));
        assertEquals(46340, mySqrt1(2147395600));
        assertEquals(4, mySqrt1(20));
        assertEquals(1, mySqrt1(1));
        mySqrt1(2147483647);
        System.out.println(System.nanoTime() - start);
    }

    public int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        int left = 0;
        int right = x / 2 + 1;
        int squareRoot = 0;
        while (left <= right) {
            squareRoot = left + (right - left) / 2;
            if (squareRoot < x / squareRoot) left = squareRoot + 1;
            else if (squareRoot > x / squareRoot) right = squareRoot - 1;
            else return squareRoot;
        }
        return right;
    }

    public int mySqrt2(int x) {
        if (x == 1 || x == 0) return x;
        int n = 2;
        while (x / n > n) {
            n++;
        }
        return x / n == n ? n : n - 1;
    }

    public int mySqrt1(int x) {
        int sqRoot = 0;
        int sq = sqRoot * sqRoot;
        double max = Math.sqrt(Integer.MAX_VALUE);
        while (sq < x && sqRoot < max) {
            sqRoot++;
            sq = sqRoot * sqRoot;
        }
        return sq == x ? sqRoot : --sqRoot;
    }

}
