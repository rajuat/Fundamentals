package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestValidParenthesis {

    @Test
    public void canTest() {
        //System.out.println("(()".lastIndexOf('('));
        //System.out.println("Result::" + longestValidParentheses("(()"));
        System.out.println("Result::" + longestValidParentheses("((())()((())())(()((())())())())(())(())()()()))(()()((()))())()))()))(((())((((()))))()()))()()(()(()((())())((())()))))())())((((()(())()))()()(((()()))()"));
        //System.out.println("Result::" + longestValidParentheses2("((())()((())())(()((())())())())(())(())()()()))(()()((()))())()))()))(((())((((()))))()()))()()(()(()((())())((())()))))())())((((()(())()))()()(((()()))()"));
    }



    public int longestValidParentheses(String s) {
        int result = 0;
        for (int left = 0; left + result < s.length(); left++) {
            if (s.charAt(left) == '(') {
                for (int right = s.length(); right - left > result; right--) {
                    if (s.charAt(right - 1) == ')') {
                        System.out.println("R: " + right + ", " + "L: " + left + ", R-L: " + (right-left) + ", and result::" + result);
                        if (right - left >= result && isValid(s.substring(left, right))) {
                            result = right - left;
                            System.out.println("Max::::" + result + " " + left + " " + right);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }



    private boolean isValid(String s) {
        System.out.println("Calls");
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counter < 0) return false;
            if (s.charAt(i) == ')') counter--;
            else if (s.charAt(i) == '(') counter++;
        }
        return counter == 0;
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        for (int left = 0, right = s.lastIndexOf(')'); right > left; left++) {
            if (s.charAt(left) == '(') {
                if (isValid(s.substring(left, right - 1))) {
                    max = Math.max(max, right - 1 - left);
                    System.out.println("L R::" + left + " " + right);
                } else {
                    right--;
                    while (s.charAt(right) != ')') {
                        right--;
                    }
                    if (isValid(s.substring(left, right))) {
                        max = Math.max(max, right - left);
                        System.out.println("L R::::" + left + " " + right);
                    }
                }
            }
        }
        return max;
    }

    Map<String, Boolean> results = new HashMap<>();
    private boolean isValid(String s, int left, int right) {
        String key = left + "-" + right;
        if (results.get(key) != null) {
            return results.get(key).booleanValue();
        }
        System.out.println("Calls");
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counter < 0) return false;
            if (s.charAt(i) == ')') counter--;
            else if (s.charAt(i) == '(') counter++;
        }
        boolean valid = counter == 0;
        results.put(key, valid);
        return counter == 0;
    }

}
