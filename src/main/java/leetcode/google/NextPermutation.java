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
    }

    @Test
    public void test() {
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

    @Test
    public void test4() {
        int[] nums3 = {1, 3, 2};
        nextPermutation(nums3);
        assertEquals("[2, 1, 3]", Arrays.toString(nums3));

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i - 1] < nums[i]) {
                searchAndSwap(nums, i - 1, nums.length - 1);
                break;
            }
            i--;
        }
        reverse(nums, i);
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        for (int k = 0; k <= (j - i) / 2; k++) {
            swap(nums, k + i, j - k);
        }
    }

    private void searchAndSwap(int[] nums, int start, int end) {
        int i = start;
        while (start < end && nums[i] < nums[start + 1]) {
            start++;
        }
        swap(nums, start, i);
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /*
    scan from right to 1 : i
    when val at i-1 is smaller than i
    look from i to end and replace i-1 with j, such that val at j is just greater than i-1
    reverse the subarray from i to end
    */


}
