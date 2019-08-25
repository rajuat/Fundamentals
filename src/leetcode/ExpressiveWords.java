package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExpressiveWords {
    @Test
    public void test1() {
        assertEquals(1, expressiveWords("heelloooo", new String[]{"hello", "hi", "helo"}));
    }

    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        List<CharCount> M = buildList(S);
        List<List<CharCount>> mList = new ArrayList<>();
        for (String word : words) {
            mList.add(buildList(word));
        }
        for (List<CharCount> word : mList) {
            int len = word.size();
            if (len == M.size()) {
                boolean match = true;
                for (int i = 0; i < len; i++) {
                    if (word.get(i).ch == M.get(i).ch) {
                        if ((M.get(i).count < 3 && M.get(i).count != word.get(i).count)) {
                            match = false;
                            break;
                        }
                    }
                }
                if (match) ans++;
            }
        }
        return ans;
    }

    List<CharCount> buildList(String S) {
        int length = S.length();
        List<CharCount> M = new ArrayList<>();
        if (S == null || length == 0) return M;
        char previousChar = S.charAt(0);
        int count = 1;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == previousChar && i < length -1) {
                count++;
            } else {
                M.add(new CharCount(previousChar, count));
                count = 1;
            }
            previousChar = c;
        }
        return M;
    }

    class CharCount {
        char ch;
        int count;

        CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

}
