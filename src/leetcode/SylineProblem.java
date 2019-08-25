package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SylineProblem {

    @Test
    public void test1() {
        int[][] buildings = new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        List<List<Integer>> res = getSkyline(buildings);
        System.out.println(res);
    }

    List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return ans;

        int n = buildings.length;
        int[][] points = new int[2 * n][2];
        for (int i = 0, p = 0; i < n; i++, p += 2) {
            points[p][0] = buildings[i][0];
            points[p + 1][0] = buildings[i][1];
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        for (int x = 0; x < 2 * n; x++) {
            int[][] overlaps = findBuildings(points[x][0], buildings);
            int a = points[x][1];
            int b = overlaps[0][2];
            System.out.println(a + ", " + b);
            points[x][1] = Math.max(a, b);
        }
        int previousHeight = 0;
        for (int x = 0; x < 2 * n; x++) {
            int height = points[x][1];
            if (height > previousHeight) {
                ans.add(Arrays.asList(points[x][0], height));
            } else if (height < previousHeight) {
                ans.add(Arrays.asList(points[x][0] - 1, height));
            }
            previousHeight = height;
        }
        ans.add(Arrays.asList(2 * n - 1, 0));
        return ans;
    }


    /*public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int n = buildings.length;
        int[] points = new int[2*n];
        for (int i = 0, p = 0; i < n; i++, p+=2) {
            points[p] = buildings[i][0];
            points[p+1] = buildings[i][1];
        }
        Arrays.sort(points);
        int lastHeight = Integer.MAX_VALUE;
        int lastX = 0;
        for (int j = 0; j < points.length; j++) {
            int[][] overlaps = findBuildings(points[j], buildings);
            //int[] building = Arrays.stream(overlaps).max(Comparator.comparingInt(x -> x[2])).get();
            for (int k = 0; k < 1; k++){
                int[] building = overlaps[k];
                int height = building[2];
                if (lastHeight != height) {
                    List<Integer> cor = new ArrayList<>();
                    cor.add(points[j]);
                    cor.add(height);
                    res.add(cor);
                    lastHeight = height;
                    //lastX = building
                    break;
                }

            }
        }
        List<Integer> cor = new ArrayList<>();
        cor.add(buildings[buildings.length -1][1]);
        cor.add(0);
        res.add(cor);
        return res;
    }
    */

    int[][] findBuildings(int j, int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        for (int[] building : buildings) {
            if (building[0] <= j && j <= building[1]) {
                res.add(new int[]{building[0], building[1], building[2]});
            }
        }
        //return res.stream().sorted(Comparator.comparingInt(value -> value[2])).toArray(int[][]:: new);
        return res.stream().sorted((x, y) -> {
            return y[2] - x[2];
        }).toArray(int[][]::new);
    }

}
