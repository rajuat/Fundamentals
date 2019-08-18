package leetcode.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NextPermutation {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        assertEquals("[1, 3, 2]", Arrays.toString(nums));

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        assertEquals("[1, 2, 3]", Arrays.toString(nums2));
    }

    @Test
    public void test2() {
        int[] nums3 = {8, 3, 7, 6, 5};
        nextPermutation(nums3);
        assertEquals("[8, 5, 3, 6, 7]", Arrays.toString(nums3));

    }

    @Test
    public void test3() {
        int[] nums3 = {2, 3, 1};
        nextPermutation(nums3);
        assertEquals("[3, 1, 2]", Arrays.toString(nums3));

    }

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (maxIndex != Integer.MIN_VALUE && maxIndex == j + 1) {
                        swap(nums, i, j);
                        if (i - j > 1 || j == 0) {
                            Arrays.sort(nums, j + 1, nums.length);
                        }
                        return;
                    } else {
                        swap(nums, j + 1, maxIndex);
                        if (j + 2 < nums.length) {
                            Arrays.sort(nums, j + 2, nums.length);
                        }
                        return;
                    }
                }
                if (nums[j] > max) {
                    maxIndex = j;
                    max = nums[j];
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
