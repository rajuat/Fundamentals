package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/340493/Google-or-Onsite-or-String-Conversion
public class StringConversion {
    boolean isConvertible(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        if(s.length() == 26) {
            if (hasAtleastOneFreeCharacter(s)) return false;
        }

        Map<Character, StringBuilder> sMap = new HashMap<>();
        Map<Character, StringBuilder> tMap = new HashMap<>();
        createMap(s, sMap);
        createMap(t, tMap);

        for(StringBuilder sb : sMap.values()){
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
