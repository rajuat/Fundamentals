package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StrobogrammaticNumber {
    /*
    1 8 0 same
    6 9 and 9 6 - opp
    2 5 3 4 7 - not allowed
    //2 5 and 5 2 - opp
    0123456789
    0060000900
     */

    @Test
    public void strobo() {
        assertTrue(isStrobogrammatic("69"));
        assertTrue(isStrobogrammatic("0060000900"));
        assertFalse(isStrobogrammatic("0060000600"));
        assertTrue(isStrobogrammatic("88"));
        assertFalse(isStrobogrammatic("962"));
        assertFalse(isStrobogrammatic("10"));
    }

    public boolean isStrobogrammatic(String num) {
        char[] number = num.toCharArray();
        int n = num.length();
        for (int i = 0; i < n ; i++) {
            char c = number[i];
            if( c == '2' || c == '3' || c == '4' || c == '5' || c == '7'){
                return false;
            }
            if(c == '6' && number[n-1-i] != '9'){
                return false;
            }
            if(c == '9' && number[n-1-i] != '6'){
                return false;
            }
            if(c == '0' && number[n-1-i] != '0'){
                return false;
            }
            if(c == '1' && number[n-1-i] != '1'){
                return false;
            }
            if(c == '8' && number[n-1-i] != '8'){
                return false;
            }
        }
        return true;
    }
}
