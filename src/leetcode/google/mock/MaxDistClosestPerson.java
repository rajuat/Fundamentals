package leetcode.google.mock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxDistClosestPerson {
    @Test
    public void maxdist() {
        assertEquals(2, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0}));
        assertEquals(1, maxDistToClosest(new int[]{1, 0, 0, 1}));
        assertEquals(1, maxDistToClosest(new int[]{0, 1}));
        assertEquals(2, maxDistToClosest(new int[]{0, 0, 1}));
    }

    public int maxDistToClosest(int[] seats) {
        int previous = 1;
        int length = 0;
        int start = 0;
        for (int end = 0; end < seats.length; end++) {
            if (previous - seats[end] == 1) {
                start = end;
            } else if (previous - seats[end] == -1) {
                int local = end - start;
                if (local % 2 != 0 && start != 0) {
                    local++;
                }
                length = Math.max(length, start == 0 ? local : (local) / 2);
            }
            previous = seats[end];
        }
        if (previous == 0) {
            length = Math.max(length, seats.length - start);
        }
        return length;
    }
}
