package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringTwoDistinctChars {

    @Test
    public void test() {
        assertEquals(3, lengthOfLongestSubstringTwoDistinct("ecebac"));
        assertEquals(6, lengthOfLongestSubstringTwoDistinct("ecebaccccc"));
        assertEquals(4, lengthOfLongestSubstringTwoDistinct("aaaa"));
        assertEquals(1, lengthOfLongestSubstringTwoDistinct("a"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] ascii = new int[128];
        int ans = 0, n = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            int jCount = ascii[s.charAt(j)];
            ascii[s.charAt(j)] = jCount + 1;
            if (jCount < 1) {
                n++;
                if (n == 3) {
                    System.out.printf("Answer: %s, %d, %d\n", s.substring(i, j), i, j);
                    ans = Math.max(ans, j - i);
                    while (n == 3 && i < j) {
                        int iCount = ascii[s.charAt(i)];
                        if (iCount == 1) {
                            n--;
                            ascii[s.charAt(i)] = iCount - 1;
                            i++;
                        } else {
                            ascii[s.charAt(i)] = iCount - 1;
                            i++;
                        }
                    }
                }
            }
        }
        ans = Math.max(ans, s.length() - i);
        System.out.printf("Answer: %s, %d, %d\n", s.substring(i, s.length()), i, s.length());
        return n < 2 ? s.length() : ans;
    }
}
