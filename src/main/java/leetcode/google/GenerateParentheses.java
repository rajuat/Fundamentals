package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateParentheses {
    @Test
    public void test1() {
        System.out.println(generateParentheses(1));
    }

    @Test
    public void test2() {
        System.out.println(generateParentheses(2));
    }

    @Test
    public void test3() {
        System.out.println(generateParentheses(3));
    }

    @Test
    public void test4() {
        System.out.println(generateParentheses(4));
    }

    public List<String> generateParentheses (int n) {
        List<String> list = new ArrayList<>();
        backtrack (list, "", 0, 0, n);
        return list;
    }

    private void backtrack (List<String> list, String ans, int open, int close, int n) {
        if (ans.length() == n*2) {
            list.add(ans);
            return;
        }
        if (open < n) {
            backtrack (list, ans + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack (list, ans + ")", open, close + 1, n);
        }
        System.out.println("4:"+ans);
    }


    private List<String> res = null;

    public List<String> parenthesis(int i) {
        res = new ArrayList<>();
        if (i==0) return res;
        char o = '(';
        char c = ')';
        parentheses(o, c, i);
        return res.stream().sorted().collect(Collectors.toList());
    }

    private void parentheses(char o, char c, int i) {
        if (i == 1) {
            res.add("" + o + c);
            return;
        }
        parentheses(o, c, i - 1);
        Set<String> ans = new HashSet<>();
        for (String s : res) {
            prefix(ans, s, o, c);
            outfix(ans, s, o, c);
            if (!s.equals("" + o + c)) {
                postfix(ans, s, o, c);
                infix(ans, s, o, c);
            }
        }
        res = new ArrayList<>(ans);
    }


    private void prefix(Set<String> ans, String s, char o, char c) {
        ans.add("" + o + c + s);
    }

    private void outfix(Set<String> ans, String s, char o, char c) {
        ans.add("" + o + s + c);
    }

    private void postfix(Set<String> ans, String s, char o, char c) {
        ans.add(s + o + c);
    }

    private void infix(Set<String> ans, String s, char o, char c) {
        int n = s.length() - 1;
        for (int i = n; i <= 0; i--) {
            ans.add("" + s.substring(0, i) + o + s.substring(i + 1, n - i) + c + s.substring(n - i));
        }
    }


}
