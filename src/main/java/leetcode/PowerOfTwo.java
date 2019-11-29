package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfTwo {

    @Test
    public void canCheckForTwosPower() {
        assertTrue(isPowerOfTwo(1));
        assertTrue(isPowerOfTwo(2));
        assertTrue(isPowerOfTwo(4));
        assertTrue(isPowerOfTwo(8));
        assertTrue(isPowerOfTwo(16));

        assertFalse(isPowerOfTwo(0));
        assertFalse(isPowerOfTwo(3));
        assertFalse(isPowerOfTwo(5));
        assertFalse(isPowerOfTwo(7));
        assertFalse(isPowerOfTwo(-2147483646));
    }

    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        int twosPower = 1;
        boolean foundAOnes = (n & twosPower) != 0;
        for (int i = 1; i < 31; i++) {
            twosPower = twosPower << 1;
            if ((n & twosPower) != 0) {
                if (foundAOnes) {
                    return false;
                }
                foundAOnes = true;
            }
        }
        return true;
    }


}
