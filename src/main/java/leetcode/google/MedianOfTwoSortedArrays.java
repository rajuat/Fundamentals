package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianOfTwoSortedArrays {

    @Test
    public void canFindMedian() {
        assertEquals(11.5, findMedianSortedArrays(new int[]{1, 3, 4}, new int[]{8, 15, 25, 35, 40}), 0.1);
        assertEquals(37.5, findMedianSortedArrays(new int[]{100, 300, 400}, new int[]{8, 15, 25, 35, 40}), 0.1);
        assertEquals(22.5, findMedianSortedArrays(new int[]{10, 20, 30}, new int[]{8, 15, 25, 35, 40}), 0.1);
        assertEquals(1.0, findMedianSortedArrays(new int[]{}, new int[]{1}), 0.1);
        assertEquals(2.5, findMedianSortedArrays(new int[]{}, new int[]{2, 3}), 0.1);
        assertEquals(2.0, findMedianSortedArrays(new int[]{2}, new int[]{}), 0.1);
        assertEquals(1.0, findMedianSortedArrays(new int[]{1}, new int[]{1}), 0.1);
        assertEquals(100000.5, findMedianSortedArrays(new int[]{100000}, new int[]{100001}), 0.1);
    }

    double median = 0.0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length - 1;
        int n2 = nums2.length - 1;

        if (n1 == -1 && n2 == -1) {
            return median;
        } else if (n1 == -1) {
            if ((n2 & 1) == 1) {
                return ((double) (nums2[n2 / 2] + nums2[(n2 / 2) + 1])) / 2.0;
            } else {
                return nums2[n2 / 2];
            }
        } else if (n2 == -1) {
            if ((n1 & 1) == 1) {
                return ((double) (nums1[n1 / 2] + nums1[(n1 / 2) + 1])) / 2.0;
            } else {
                return nums1[n1 / 2];
            }
        } else if (n1 < n2) {
            findMedian(nums1, nums2, n1, n2, 0, n1);
        } else {
            findMedian(nums2, nums1, n2, n1, 0, n2);
        }
        return median;
    }

    private void findMedian(int[] nums1, int[] nums2, int n1, int n2, int start, int end) {
        int index1 = (start + end) / 2;
        int index2 = ((n1 + n2 - 1) / 2) - index1;

        int highestOfLeft1 = index1 == -1 ? Integer.MIN_VALUE : nums1[index1];
        int highestOfLeft2 = index2 == -1 ? Integer.MIN_VALUE : nums2[index2];
        int lowestOfRight1 = index1 == n1 ? Integer.MAX_VALUE : nums1[index1 + 1];
        int lowestOfRight2 = index2 == n2 ? Integer.MAX_VALUE : nums2[index2 + 1];

        if (highestOfLeft1 <= lowestOfRight2 && highestOfLeft2 <= lowestOfRight1) {
            if ((n1 + n2) % 2 == 1 ) {
                median = Math.max(highestOfLeft1, highestOfLeft2);
            } else if((n1 + n2) == 0){
                double sum = highestOfLeft1 + highestOfLeft2;
                median = sum / 2.0;
            } else {
                int max = Math.max(highestOfLeft1, highestOfLeft2);
                int min = Math.min(lowestOfRight1, lowestOfRight2);
                double sum = (max == Integer.MIN_VALUE ? 0 : max) + (min == Integer.MAX_VALUE ? 0 : min);
                median = sum / 2.0;
            }
            return;
        }

        if (highestOfLeft1 > lowestOfRight2) {
            if (index1 == 0) {
                end = -2;
            } else {
                end = index1;
            }
        } else if (highestOfLeft2 > lowestOfRight1) {
            start = index1 + 1;
        }
        findMedian(nums1, nums2, n1, n2, start, end);
    }
}
