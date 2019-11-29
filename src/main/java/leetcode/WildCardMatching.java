package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WildCardMatching {

    //not fully done
    @Test
    public void canCheckForWilCardMatching() {
        assertTrue(isMatch("aabxxxbxxxba", "*ab**ba"));
    }

    public boolean isMatch(String inputString, String pattern) {
        int runningInputIndex = 0;
        int starIndex = pattern.indexOf('*');
        int inputIndex = 0;
        for (; inputIndex < starIndex; inputIndex++) {
            if (pattern.charAt(inputIndex) != inputString.charAt(inputIndex)) return false;
        }
        while (starIndex != -1) {
            int starNextIndex = pattern.indexOf('*', starIndex);
            if (starIndex < starNextIndex) {
                String patternLiterals = pattern.substring(starIndex + 1, starNextIndex);
                int matchingIndex = inputString.indexOf(patternLiterals, inputIndex);
                if (matchingIndex != -1) {
                    inputIndex = matchingIndex + patternLiterals.length();
                } else {
                    return false;
                }
            } else {
                //last star
                for (int j = starIndex + 1; j < pattern.length(); j++, inputIndex++) {
                    if (inputIndex < inputString.length() && pattern.charAt(j) != inputString.charAt(inputIndex)) return false;
                }
            }
            starIndex = starNextIndex;
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
