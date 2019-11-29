package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class TappingRainWater {
    @Test
    public void test1() {
        assertEquals(6, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    public void test2() {
        assertEquals(14, trap(new int[]{5, 2, 1, 2, 1, 5}));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int ans = 0;
        List<Integer[]> walls = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            if (height[i] > left && height[i] > height[i + 1]) {
                walls.add(new Integer[]{height[i], i});
            }
            left = height[i];
        }
        if (height[n - 1] > height[n - 2]) {
            walls.add(new Integer[]{height[n - 1], n - 1});
        }
        //walls.sort(Comparator.comparingInt(o -> o[0]));
        Stack<Integer[]> stack = new Stack<>();
        for (int k = 0; k < walls.size() - 1; k++) {
            int l = walls.get(k)[1];
            int r = walls.get(k + 1)[1];
            if ( l > r) {
                stack.add(walls.get(k));
                l = r;
            } else if (r > l){
                Integer[] lastLeft = null;
                while(!stack.isEmpty() && stack.peek()[0] < r){
                    lastLeft = stack.pop();
                }
            }
        }


        int start = -1;
        int end = 0;
        for (int j = 0; j < n; j++) {
            if (0 > 0) {
                if (start < end) {
                    start = j;
                } else {
                    end = j;
                    ans += calculate(height, start, end);
                    start = end;
                }
            }
        }
        return ans;
    }

    int calculate(int[] height, int start, int end) {
        int ans = 0;
        int h = Math.min(height[start], height[end]);
        for (int i = start + 1; i < end; i++) {
            int x = h - height[i];
            ans += (x > 0) ? x : 0;
        }
        return ans;
    }
}



