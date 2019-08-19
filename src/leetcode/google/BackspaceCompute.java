package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackspaceCompute {

    @Test
    public void test1() {
        assertTrue(backspaceCompare("abck#defkl##ghz#ix#j", "az#bcdv#efb#ghijg#"));
    }

    @Test
    public void test2() {
        assertTrue(backspaceCompare("ab#c", "ad#c"));

    }

    @Test
    public void test3() {
        assertTrue(backspaceCompare("ab##", "c#d#"));

    }

    @Test
    public void test4() {
        assertTrue(backspaceCompare("a##c", "#a#c"));
    }

    @Test
    public void test5() {
        assertFalse(backspaceCompare("a#c", "b"));
    }

    @Test
    public void test6() {
        assertTrue(backspaceCompare("y#fo##f", "y#fx#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == T;
        int i = S.length() - 1;
        int j = T.length() - 1;
        int sCount = 0;
        int tCount = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    sCount++;
                    i--;
                } else if (sCount > 0) {
                    sCount--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    tCount++;
                    j--;
                } else if (tCount > 0) {
                    tCount--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            if (i >= 0 != j >= 0) return false;

            i--;
            j--;
        }
        return true;
    }


    public boolean backspaceCompare1(String S, String T) {
        if (S == null || T == null) return S == T;
        int i = S.length() - 1;
        int j = T.length() - 1;
        while (i >= 0 && j >= 0) {
            i = findCurrentIndex(S, i);
            j = findCurrentIndex(T, j);
            if (i <= 0 && j <= 0) return true;
            System.out.printf("val s and t, i and j: %s, %s, %d, %d, \n", S.charAt(i), T.charAt(j), i, j);
            if (S.charAt(i) != T.charAt(j)) return false;
            i--;
            j--;
        }
        return i == j;
    }

    int findCurrentIndex(String s, int i) {
        while (i > 0 && s.charAt(i) == '#') {
            if (s.charAt(i - 1) == '#') {
                i = i - 4;
            } else {
                i = i - 2;
            }
        }
        return i;
    }


}
