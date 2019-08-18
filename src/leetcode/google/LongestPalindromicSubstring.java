package leetcode.google;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstring {
    @Test
    public void printLongestPalindrome() {
        long start = System.currentTimeMillis();
        assertEquals("bab", longestPalindrome("babad"));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        assertEquals("bab", dymanicProgramming("babad"));
        System.out.println(System.currentTimeMillis() - start);
    }

    String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (end - start + 1 < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.printf("len, start and end, %d, %d, %d \n" , len, start, end);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    String dymanicProgramming(String s) {
        Set<String> p = new HashSet<>();
        int max = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        int size = 1;
        while (size < n) {
            for (int i = 0; i + size < n; i = i + size) {
                if (isPalindrome(s, i, i + size, p)) {
                    String entry = i + "," + i + size;
                    p.add(entry);
                    if (size > max) {
                        max = size;
                        start = i;
                        end = i + size;
                    } else if (size == max && start < i) {
                        start = i;
                        end = i + size;
                    }
                }
                size++;
            }
        }
        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(String s, int i, int j, Set<String> p) {
        while (i < j) {
            if (p.contains(i + "," + j)) {
                return true;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
