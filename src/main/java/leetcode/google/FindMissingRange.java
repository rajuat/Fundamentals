package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRange {
    @Test
    public void find() {
        List<String> ans = null;
        ans = findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{}, 1, 1);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{0, 1}, 0, 1);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{1}, 0, 1);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{2}, 0, 2);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{2147483647}, 0, 2147483647);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{-2147483648, -2147483648, 0, 2147483647, 2147483647}, -2147483648, 2147483647);
        System.out.println(ans);
        ans = findMissingRanges(new int[]{2147483647}, -2147483648, 2147483647);
        System.out.println(ans);

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            ans.add(lower == upper ? "" + lower : lower + "->" + upper);
            return ans;
        }
        int start = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lower) {
                continue;
            } else if (nums[i] == lower) {
                start = lower;
            } else if (start == Integer.MIN_VALUE) {
                start = lower;
                add(ans, (start == Integer.MIN_VALUE) ? start : start - 1, nums[i]);
                start = nums[i];
            } else if (nums[i] < upper) {
                add(ans, start, nums[i]);
                start = nums[i];
            } else if (nums[i] == upper) {
                add(ans, start, (i == nums.length - 1 || upper == Integer.MAX_VALUE) ? upper : upper + 1);
                break;
            }
        }
        if (nums[nums.length - 1] < upper) {
            add(ans, nums[nums.length - 1], upper + 1);
        }
        return ans;
    }

    void add(List<String> ans, int left, int right) {
        if (left + 2 < right) {
            ans.add((left + 1) + "->" + (right - 1));
        } else if (left + 2 == right) {
            ans.add("" + (left + 1));
        }
    }
}
