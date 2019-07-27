package leetcode.google;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/explore/interview/card/google/59/array-and-strings/3059/
public class MeetingRoomII {

    @Test
    public void count() {
        assertEquals(2, minMeetingRooms(new int[][]{{0, 30}, {15, 20}, {5, 10}}));
        assertEquals(1, minMeetingRooms(new int[][]{{0, 15}, {15, 20}}));
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((a) -> a[0]));
        int minMeetingRooms = 0;
        int startTime = 0;

        for (int i = 0; i < intervals.length; i++) {
            while (i < intervals.length - 1 && startTime == intervals[i+1][0]) {
                i++;
            }
            startTime = intervals[i][0];

            int meetingRooms = 0;
            for (int j = 0; j <= i; j++) {
                if (intervals[j][0] <= startTime && intervals[j][1] > startTime) {
                    meetingRooms++;
                }
            }
            if (meetingRooms > minMeetingRooms) {
                minMeetingRooms = meetingRooms;
            }
        }
        return minMeetingRooms;
    }

}
