package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WildCardMatching {

    @Test
    public void canCheckForWilCardMatching() {
        assertTrue(isMatch("aabxxxbxxxba", "*ab**ba"));
    }

    public boolean isMatch(String inputString, String pattern) {
        int runningInputIndex = 0;
        int starIndex = pattern.indexOf('*');
        for (int i = 0; i < starIndex; i++) {
            if (pattern.charAt(i) != inputString.charAt(i)) return false;
        }
        while (starIndex != -1) {
            int starNextIndex = pattern.indexOf('*', starIndex);
            if (starIndex < starNextIndex) {
                String patternLiterals = pattern.substring(starIndex + 1, starNextIndex);
                int i = inputString.indexOf(patternLiterals, starIndex);
                if (i != -1) {
                    starIndex = i + patternLiterals.length();
                } else {
                    return false;
                }
            }

        }


        /*int runningIndex = 0;
        boolean scanningWithinWildcard = false;
        for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex++) {
            char c = pattern.charAt(patternIndex);
            if (c == '*') {
                scanningWithinWildcard = true;
                continue;
            }
            if (scanningWithinWildcard) {
                scanningWithinWildcard = false;
                runningIndex = inputString.indexOf(c, runningIndex);
                if (runningIndex == -1) return false;
            }
            if (c == inputString.charAt(runningIndex)) {
                runningIndex++;
            } else {
                return false;
            }

        }*/

        return true;
    }
}
