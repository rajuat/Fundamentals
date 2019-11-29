package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextClosestTime {
    @Test
    public void getNextTime() {
        assertEquals("22:22", nextClosestTime("23:57"));
        assertEquals("23:55", nextClosestTime("23:54"));
        assertEquals("23:52", nextClosestTime("23:51"));
        assertEquals("18:44", nextClosestTime("18:42"));
        assertEquals("15:11", nextClosestTime("13:55"));
        assertEquals("22:32", nextClosestTime("22:23"));
    }


    public String nextClosestTime(String time) {
        int hh = Integer.valueOf(time.substring(0, 2));
        int mm = Integer.valueOf(time.substring(3));
        int[] digit = new int[]{hh / 10, hh % 10, mm / 10, mm % 10};
        int min = 10;
        for (int i = 0; i < 4; i++) {
            min = digit[i] < min ? digit[i] : min;
        }

        String res = null;
        res = foundNext(digit, 3, 9, min);
        if (res != null) return res;

        if (digit[2] < 5) {
            res = foundNext(digit, 2, 5, min);
            if (res != null) return res;
        }

        if (digit[0] == 2) {
            res = foundNext(digit, 1, 3, min);
            if (res != null) return res;
        }
        if (digit[0] < 2) {
            res = foundNext(digit, 1, 9, min);
            if (res == null) {
                res = foundNext(digit, 0, 2, min);
            }
            if (res != null) {
                return res;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(min);
        sb.append(':');
        sb.append(min);
        sb.append(min);
        return sb.toString();

    }

    String foundNext(int[] digit, int comparingIndex, int max, int min) {
        int diff = 10;
        int index = -1;

        for (int i = 0; i <= 3; i++) {
            int localDiff = digit[i] - digit[comparingIndex];
            if (localDiff > 0 && digit[i] <= max) {
                if (diff > localDiff) {
                    diff = localDiff;
                    index = i;
                }
            }
        }
        if (index != -1) {
            digit[comparingIndex] = digit[index];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= 3; j++){
                sb.append(comparingIndex < j ? min : digit[j]);
            }
            sb.insert(2, ':');
            return sb.toString();
        }
        return null;
    }
}