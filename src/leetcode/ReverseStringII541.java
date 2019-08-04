package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReverseStringII541 {

    @Test
    public void reverse() {
        assertEquals("bacdqprsfeg", reverseStr("abcdpqrsefg", 2));
        assertEquals("bacd", reverseStr("abcd", 2));
        assertEquals("cbad", reverseStr("abcd", 3));
    }

    public String reverseStr(String s, int k) {

        int n = s.length();
        char[] c = s.toCharArray();
        int partition = n / (2 * k);
        int start = 0;

        for (int i = 0; i < partition; i++) {
            start = i * (2 * k);
            reverseString(c, start, start + k);
        }

        int current = partition * 2 * k;
        if (current < n) {
            start = current;
            if (n - start < k) {
                reverseString(c, start, n);
            } else {
                reverseString(c, start, start + k);
            }
        }
        return String.valueOf(c);
    }

    public void reverseString(char[] s, int start, int end) {

        for (int i = start; i < (start + ((end - start) / 2)); i++) {
            char c = s[i];
            int right = start + end - 1 - i;
            s[i] = s[right];
            s[right] = c;
        }
    }
}
