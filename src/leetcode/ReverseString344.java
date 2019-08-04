package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseString344 {
    @Test
    public void reverse(){
        char[] s = "ab".toCharArray();
        reverseString(s);
        assertEquals("ba", String.valueOf(s));
        char[] t = "abcde".toCharArray();
        reverseString(t);
        assertEquals("edcba", String.valueOf(t));
    }

    public void reverseString(char[] s){
        for(int i = 0 ; i < s.length / 2; i++){
            char c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
        }
    }

}
