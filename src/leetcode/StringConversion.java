package leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/discuss/interview-question/340493/Google-or-Onsite-or-String-Conversion
public class StringConversion {

    @Test
    public void convert() {
        assertTrue(convertible("abca", "dced"));
        assertTrue(convertible("ab", "ba"));
        assertFalse(convertible("aa", "cd"));
        assertTrue(convertible("ab", "aa"));
        assertFalse(convertible("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
    }

    boolean convertible(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;

        Set<Integer> indexSet = new HashSet<>();
        Set<Integer> charIndexSet = new HashSet<>();
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charSet.add(c);
            if (!indexSet.contains(Integer.valueOf(i))) {
                indexSet.add(i);
                charIndexSet.add(i);
                int foundIndex = s.indexOf(c, i + 1);
                while (foundIndex != -1) {
                    indexSet.add(foundIndex);
                    charIndexSet.add(foundIndex);
                    foundIndex = s.indexOf(c, foundIndex + 1);
                }
                if (sameIndexHasSameChar(t, charIndexSet)) return false;
                charIndexSet.clear();
            }
        }
        //contains all alphabet and dont have a buffer to holding a temp char
        if(charSet.size() == 26) return false;

        return true;
    }

    private boolean sameIndexHasSameChar(String t, Set<Integer> charIndexSet) {
        char ct = 0;
        for (int index : charIndexSet) {
            char ch = t.charAt(index);
            if (ct == 0) {
                ct = ch;
            } else {
                if (ct != ch) return true;
            }
        }
        return false;
    }


    boolean isConvertible(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        if (s.length() == 26) {
            if (hasAtleastOneFreeCharacter(s)) return false;
        }

        Map<Character, StringBuilder> sMap = new HashMap<>();
        Map<Character, StringBuilder> tMap = new HashMap<>();
        createMap(s, sMap);
        createMap(t, tMap);

        for (StringBuilder sb : sMap.values()) {
            //  String indexes = sb.

        }

        return false;

    }

    private boolean hasAtleastOneFreeCharacter(String s) {
        for (int character = 97; character <= 122; character++) {
            int index = s.indexOf(character);
            if (index == -1) {
                return true;
            }
        }
        return false;
    }

    private void createMap(String s, Map<Character, StringBuilder> sMap) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sMap.containsKey(c)) {
                StringBuilder sb = sMap.get(c);
                sb.append(",");
                sb.append(i);
            } else {
                sMap.put(c, new StringBuilder(i));
            }
        }
    }
}
