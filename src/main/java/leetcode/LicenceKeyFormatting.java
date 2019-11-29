package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LicenceKeyFormatting {
    @Test
    public void test1() {
        assertEquals("5F3Z-2E9W", licenceKeyFormatting("5F3Z-2e-9-w", 4));
    }

    @Test
    public void test2() {
        assertEquals("24A0-R74K", licenceKeyFormatting("2-4A0r7-4k", 4));
    }

    @Test
    public void test3() {
        assertEquals("AA-AA", licenceKeyFormatting("--a-a-a-a--", 2));
    }

    public String licenceKeyFormatting(String S, int K) {
        StringBuilder ans = new StringBuilder();
        int count = K;
        int i = S.length() - 1;
        while (i >= 0) {
            if (count > 0) {
                char c = S.charAt(i);
                if (c != '-') {
                    ans.append(Character.isDigit(c) ? c : Character.toUpperCase(c));
                    count--;
                }
                i--;
            } else if (i != 0){
                count = K;
                ans.append('-');
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() -1) == '-') ans.deleteCharAt(ans.length() -1);
        return ans.reverse().toString();
    }

}
