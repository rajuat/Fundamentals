package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongesSubstringNonRepeat {

    @Test
    public void canCount() {
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        assertEquals("1", 3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals("2", 1, lengthOfLongestSubstring("bbb"));
        assertEquals("3", 1, lengthOfLongestSubstring(" "));
        assertEquals("4", 3, lengthOfLongestSubstring("dvdf"));
        assertEquals("5", 3, lengthOfLongestSubstring("pwwkew"));
        assertEquals("6", 5, lengthOfLongestSubstring("ckilbkd"));
        assertEquals("7", 2, lengthOfLongestSubstring("abb"));
        assertEquals("8", 0, lengthOfLongestSubstring(""));
    }

    int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] alphabets = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(i, alphabets[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            alphabets[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    public int longestSubstring(String s) {
        int[] characters = new int[128];
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters[c] > 0) {
                max = Math.max(max, i - left);
                if (s.charAt(i - 1) == c) left = i;
                else left = Math.max(left, characters[c]);
                characters[c] = i + 1;
            } else {
                characters[c] = i + 1;
            }
        }
        max = Math.max(max, s.length() - left);
        return max == 0 ? s.length() : max;
    }

    public int lengthOfLongestSubstring2(String s) {
        boolean[] characters = new boolean[128];
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters[c]) {
                max = Math.max(max, i - left);
                if (s.charAt(i - 1) == c) left = i;
                else left++;
            } else {
                characters[c] = true;
            }
        }
        max = Math.max(max, s.length() - left);
        return max == 0 ? s.length() : max;
    }
}
