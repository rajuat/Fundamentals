package leetcode.google;

import org.junit.Test;

import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

public class WordSquare {

    @Test
    public void printSquares() {
        List<List<String>> res = null;
        String[] words = new String[]{
                "ball",
                "area",
                "lead",
                "lady",
                "wall"
        };
        res = wordSquares(words);
        res.stream().forEach(System.out::println);
        res = wordSquares(new String[]{"a"});
        res.stream().forEach(System.out::println);
    }

    private int n = 0;
    private List<String> words = null;
    private List<List<String>> squares = null;
    private Map<Character, List<String>> charMap = null;

    List<List<String>> wordSquares(String[] words) {
        squares = new ArrayList<>(); //c1
        if (words == null || words.length == 0 || words[0].length() == 0) return squares; //c2
        n = words[0].length(); //c3
        this.words = Arrays.asList(words); //n
        this.charMap = new HashMap<>();//c4
        for (int i = 0; i < words.length; i++) { //n
            char c = words[i].charAt(0);//c5
            List<String> charList = this.words.stream().filter(x -> x.charAt(0) == c).collect(Collectors.toList());//n
            charMap.put(c, charList);//c6
        }

        for (String word : words) {//n
            char[][] sq = new char[n][n];//c7
            sq[0] = word.toCharArray();//c8
            backtrack(sq, 0);
        }
        return squares;
    }

    void backtrack(char[][] sq, int index) {
        if (index + 1 == n) {
            addSquareToResult(sq);
            return;
        }
        char[] word = sq[0];
        char c = word[index + 1];
        List<String> charList = charMap.get(c);
        int[] hasCheckAtIndex = new int[this.words.size()];
        for (int i = 0; charList != null && i < charList.size(); i++) {//s
            if (hasCheckAtIndex[i] != index + 1) {
                sq[index + 1] = charList.get(i).toCharArray();
                hasCheckAtIndex[i] = index + 1;
                if (isSquare(sq, index + 1)) {
                    //if index has reach n then one sq is form
                    if (index + 2 == n) {
                        addSquareToResult(sq);
                        continue; //backtrack
                    } else {
                        backtrack(sq, index + 1);
                    }
                    //on else is backtrack
                }
            }
        }
    }

    private void addSquareToResult(char[][] sq) {
        List<String> square = new ArrayList<>();
        for (int i = 0; i < sq.length; i++) {
            String s = String.valueOf(sq[i]);
            square.add(i, s);
        }
        squares.add(square);
     }

    boolean isSquare(char[][] sq, int len) {
        for (int i = 0; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (sq[i][j] != sq[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}