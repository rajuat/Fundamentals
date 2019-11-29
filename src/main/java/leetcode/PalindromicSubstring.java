package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PalindromicSubstring {
    @Test
    public void canDetermineNumberOfPalindromes() {
        assertFalse(isPalindrome("ab"));
        assertTrue(isPalindrome("arora"));
        assertTrue(isPalindrome("arra"));
        assertFalse(isPalindrome("abc"));
        assertEquals("1", 6, countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        Map<Integer, Boolean> palindromes = new HashMap<>();
        int count = 0;
        for (int palindromLength = 1; palindromLength <= s.length(); palindromLength++) {
            int left = 0;
            int right = left + palindromLength;
            while (right <= s.length()) {
                String substring = s.substring(left, right);
                if (palindrome(substring, palindromes, left, right)) {
                    count++;
                }
                left++;
                right++;
            }
        }
        return count;
    }

    private boolean palindrome(String s, Map<Integer, Boolean> palindromes, int left, int right) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            } else {
                int key = (left + 1) * 1000 + (right - 1);
                if (palindromes.get(key) == Boolean.TRUE) {
                    break;
                }
            }
        }
        palindromes.put(left * 1000 + right, Boolean.TRUE);
        return true;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }



/*

    private int countPossiblePalindromes(String s) {
        int counter = 0;
        Map<Character, Integer> multipleCounter = new HashMap<>();
        Set<Character> singleCounter = new HashSet();

        prepareCharactersCounter(s, multipleCounter, singleCounter);

        for (char c : singleCounter) {
            counter++;
        }

        Map<Character, Integer> charactersPermutation = new HashMap();

        for (char multiple : multipleCounter.keySet()) {
            int cCounter = multipleCounter.get(multiple);

            //"aaa" gives a a a aa aaa
            counter = counter + cCounter * 2 - 1;

            // for each unique char, wraps the other chars. aaaabc gives aba aabaa aca aacaa
            int permutations = singleCounter.size() * cCounter / 2;
            counter = counter + permutations;

            charactersPermutation.put(multiple, permutations);

        }

        //if aaaabc were aaaabcdddd and a was processed earlier
        for (char cPermutation : charactersPermutation.keySet()) {
            int countForEachChar = charactersPermutation.get(cPermutation);

            int cCounter = multipleCounter.get(cPermutation);
            int noOfPossiblePlacetoPutAChar = noOfPossiblePlacetoPutAChar(cCounter);
            int totalNoOfPossiblePlacetoPutChars = singleCounter.size() * noOfPossiblePlacetoPutAChar;


        }
        return counter;
    }

    //if aba aabaa aaabaaa aaaabaaaa (14) OR aba aabaa aca aacaa (10)
    private int noOfPossiblePlacetoPutAChar(int cCounter) {
        int n = cCounter + 1;
        return ((n * (n + 1)) / 2) - 1;
    }

    private void prepareCharactersCounter(String s, Map<Character, Integer> multipleCounts, Set<Character> singleCounts) {
        char[] input = s.toCharArray();
        Arrays.sort(input);
        int i = 0;
        while (i < input.length - 1) {
            int similarChars = 1;
            while (input[i] == input[i + 1]) {
                similarChars++;
                i++;
            }
            if (similarChars == 1) singleCounts.add(input[i]);
            else multipleCounts.put(input[i], similarChars);
        }
        //handling last element
        if (i == input.length - 2) {
            singleCounts.add(input[i]);
        }
    }
*/
}
