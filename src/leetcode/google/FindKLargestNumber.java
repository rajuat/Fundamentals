package leetcode.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindKLargestNumber {

    @Test
    public void test1() {
        assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));
        assertEquals(2, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 5));
    }

    @Test
    public void test2() {
        assertEquals(1, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 6));
    }

    int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return Integer.MIN_VALUE;
        int n = nums.length - 1;
        buildMaxHeap(nums);
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, n - i);
            maxHeapify(nums, 0, n - 1 - i);
        }
        return nums[0];
    }

    void buildMaxHeap(int[] nums) {
        int n = nums.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
    }

    void maxHeapify(int[] nums, int i, int n) {
        int largest = -1;
        int left = 2 * i + 1;
        int right = left + 1;

        if (left <= n && nums[i] < nums[left]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= n && nums[largest] < nums[right]) {
            largest = right;
        }
        if (i != largest) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, n);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void heapify(int[] nums, int i, int j) {
        if (i >= j) return;
        int curr = i;
        int left = 2 * curr + 1;
        int right = 2 * curr + 2;
        int largest = -1;
        while (left <= j && right <= j) {
            if (nums[left] > nums[right]) {
                largest = left;
            } else {
                largest = right;
            }
            if (nums[curr] >= nums[largest]) {
                return;
            } else {
                swap(nums, curr, largest);
            }
            curr = left + 1;
            left = 2 * curr + 1;
            right = 2 * curr + 2;
        }
        while (left <= j) {
            if (nums[curr] >= nums[left]) {
                return;
            } else {
                swap(nums, curr, left);
                curr = left + 1;
                left = 2 * curr + 1;
            }
        }
        while (right <= j) {
            if (nums[curr] >= nums[left]) {
                return;
            } else {
                swap(nums, curr, right);
                curr = right + 1;
                right = 2 * curr + 2;
            }
        }
    }

}
