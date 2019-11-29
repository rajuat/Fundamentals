package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class WiggleSort {
    @Test
    public void test1() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        ws(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void ws(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    exch(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    exch(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (i % 2 == 0) {
                    if (nums[j] < nums[minIndex]) minIndex = j;
                } else {
                    if (nums[j] > nums[maxIndex]) maxIndex = j;
                }
            }
            if (i % 2 == 0) {
                exch(nums, i, minIndex);
            } else {
                exch(nums, i, maxIndex);
            }
        }
    }

    void exch(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

}
