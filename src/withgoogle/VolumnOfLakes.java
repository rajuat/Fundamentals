package withgoogle;

/*
Imagine an island that is in the shape of a bar graph.
When it rains, certain areas of the island fill up with rainwater to form lakes.
Any excess rainwater the island cannot hold in lakes will run off the island
to the west or east and drain into the ocean.

Given an array of positive integers representing 2-D bar heights,
design an algorithm (or write a function) that can compute the total volume (capacity)
of water that could be held in all lakes on such an island
given an array of the heights of the bars.
Assume an elevation map where the width of each bar is 1.

Example: Given [1,3,2,4,1,3,1,4,5,2,2,1,4,2,2],
return 15 (3 bodies of water with volumes of 1,7,7 yields total volume of 15)

apprach
1 all integers
2 two or more local lakes can merge and form a bigger lake
3 rainfall is unlimited and uniform
 */

import org.junit.Test;

import java.util.*;

public class VolumnOfLakes {

    @Test
    public void canCalArea() {
        System.out.println(calculateArea(new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2}));

    }

    int calculateArea(int[] A) {
        int area = 0;
        int totalArea = 0;
        int benchmark = 0;
        boolean lakeInProgress = false;
        int lakeStartIndex = 0;
        int lakeEndIndex = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (!lakeInProgress) {
                if (A[i] < A[i + 1]) {
                    continue;
                } else if (!lakeInProgress) {
                    lakeInProgress = true; //lake starts
                    lakeStartIndex = i;
                    benchmark = A[i];
                    area += benchmark - A[i + 1];
                } else {
                    lakeInProgress = true;
                    area += benchmark - A[i + 1];
                }
            } else {
                if (A[i] < A[i + 1]) {
                    if (benchmark > A[i + 1]) {
                        area += benchmark - A[i + 1];
                    } else {
                        lakeInProgress = false; //lake over
                        lakeEndIndex = i;
                        totalArea = totalArea + area;
                        System.out.println("right high lake: " + area);
                    }
                } else { //lake over
                    lakeInProgress = false;
                    lakeEndIndex = i;
                    if (benchmark > A[i]) {
                        int factorReduction = benchmark - A[i];
                        area -= factorReduction * (lakeEndIndex - lakeStartIndex);
                        totalArea = totalArea + area;
                        System.out.println("left high lake: " + area);
                    }
                }
            }
        }
        return totalArea;
    }


    ///////////////////////////////

    @Test
    public void canCal() {
        //f(new int[] {10,30,20,40,15,35,17,40,5,23,27,13,45,24,29});
        f(new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2});
        System.out.println(totalArea);
    }


    List<Integer> visitedLocations = null;
    List<VisitedBoundary> visitedBoundaries = new ArrayList<>();
    List<Island> locationHeight = null;
    HashMap<Integer, Island> islandMap = null;
    int totalArea = 0;
    int size = 0;

    void f(int[] island) {
        //set up
        size = island.length;
        islandMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            islandMap.put(i, new Island(i, island[i]));
        }
        locationHeight = new ArrayList(islandMap.values());
        Collections.sort(locationHeight);

        visitedLocations = new ArrayList<>();

        v(0);
    }

    private void v(int i) {
        System.out.println("visitedLocations.size() " + visitedLocations.size());
        if (visitedLocations.size() == size - 2) {
            return;
        }
        Island highestLocation = locationHeight.get(i);
        Island nextHighest = locationHeight.get(i + 1);

        int highIndex = highestLocation.location;
        int nextHighIndex = nextHighest.location;
        int range = highIndex - nextHighIndex;
        VisitedBoundary leftToRight = new VisitedBoundary(highIndex, true);
        VisitedBoundary rightToLeft = new VisitedBoundary(highIndex, false);

        if (visitedBoundaries.contains(leftToRight) && visitedBoundaries.contains(rightToLeft)) {
            visitedLocations.add(highIndex); //both side covered
        }

        if (range < -1 && !visitedBoundaries.contains(leftToRight)) {//next is on right with atleast one bar in between
            visitedBoundaries.add(leftToRight);
            //visitedBoundaries.add(new VisitedBoundary(nextHighIndex, false));
            totalArea += calculateArea(highIndex, range, nextHighest.height);
            i++;
            v(i);
        } else if (range > 1 && !visitedBoundaries.contains(rightToLeft)) {//next is on left with atleast one bar in between
            visitedBoundaries.add(rightToLeft);
            //visitedBoundaries.add(new VisitedBoundary(nextHighIndex, true));
            totalArea += calculateArea(nextHighIndex, range, nextHighest.height);
            i++;
            v(i);
        } else {
            visitedLocations.add(nextHighIndex);//they are adjacent
            //locationHeight.remove(i + 1);
            v(i);
        }
    }

    int calculateArea(int index, int range, int lowerHeight) {
        int area = 0;
        for (int i = index + 1; i < index + range; i++) {
            if (visitedLocations.contains(i)) {
                continue;
            }
            Island islandComponent = islandMap.get(i);
            area += lowerHeight - islandComponent.height;
            visitedLocations.add(i);
        }
        return area;
    }
}

class Island implements Comparable<Island> {
    int location;
    int height;

    public Island(int location, int height) {
        this.location = location;
        this.height = height;
    }

    @Override
    public int compareTo(Island island) {
        return island.height - height;
    }
}

class VisitedBoundary {
    int location;
    boolean leftToRight;

    public VisitedBoundary(int location, boolean leftToRight) {
        this.location = location;
        this.leftToRight = leftToRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitedBoundary that = (VisitedBoundary) o;
        return location == that.location &&
                leftToRight == that.leftToRight;
    }

    @Override
    public int hashCode() {

        return Objects.hash(location, leftToRight);
    }
}

