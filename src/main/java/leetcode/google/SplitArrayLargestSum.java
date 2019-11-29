package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplitArrayLargestSum {

    @Test
    public void findMax() {
        assertEquals(18, splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int m) {
        int largestSum = 0;
        int n = nums.length - 1;
        for (int h = 0; h < m - 1; h++) {
            largestSum = Math.max(largestSum, nums[h]);
        }
        findMaxSum(nums, m , largestSum, 1);
        return largestSum;
    }

    void findMaxSum(int[] nums, int mIndex, int largestSum, int increment) {
        int sum = 0;
        for (int i = 0; i < increment; i++) {
            sum += nums[i + mIndex - increment];
        }
        largestSum = Math.max(largestSum, sum);
        sum = 0;
        for (int j = mIndex + increment; j < nums.length; j++) {
            sum += nums[j];
        }
        largestSum = Math.max(largestSum, sum);
        if (increment < nums.length - mIndex) {
            findMaxSum(nums, mIndex, largestSum, increment + 1);
        }
        if (mIndex > 0)
            findMaxSum(nums, mIndex - 1, largestSum, increment);
    }

}
