package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMissingPositive41 {

    @Test
    public void canFIndMissingInteger() {assertEquals(3, firstMissingPositive(new int[]{0, 1, 2}));
        assertEquals(2, firstMissingPositive(new int[]{0, 1, 3}));
        assertEquals(1, firstMissingPositive(new int[]{0, 3, 2}));
        assertEquals(4, firstMissingPositive(new int[]{0, 3, 2, 5, 7, 1}));

        assertEquals(3, firstMissingPositive(new int[]{2, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int n = 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == n) {
                n++;
                i = -1;
            }
            i++;
        }
        return n;
    }
}
