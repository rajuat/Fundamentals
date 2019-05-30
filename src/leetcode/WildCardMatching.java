package leetcode;

public class WildCardMatching {

    public boolean isMatch(String s, String p) {

        for (int iS = 0, jP = 0; iS < p.length(); ) {
            char c = p.charAt(iS);

            if (c == '?') {
                jP++; iS++;
            } else if(c == '*'){

            }


            if (s.charAt(jP) == c) {

            }
        }

        return true;
    }
}
