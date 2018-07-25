package techdevguide;

import java.util.HashMap;

public class SubSequence {

    String S = "abppplee";
    String[] D = {"able", "ale", "apple", "bale", "kangaroo"};

    void find() {
        HashMap<Integer, Integer> indexCount = new HashMap<>();
        for (int i = 0; i < D.length; i++) {
            String word = D[i];
            int iS = 0;
            boolean isSubsequnce = true;
            for (int j = 0; j < word.length(); j++) {
                for (int k = iS; k < S.length(); k++) {
                    if (word.charAt(j) == S.charAt(k)) {
                        iS = k;
                        break;
                    }
                }
                if (iS == S.length() - 1) {
                    isSubsequnce = false;
                }
            }
            if (isSubsequnce) {
                indexCount.put(i, word.length()); 
            }
        }
    }
}
