package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MoveZeroes283 {

    @Test
    public void move() {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
        assertEquals("[1, 3, 12, 0, 0]", Arrays.toString(a));
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        if (left != right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
    }
}
