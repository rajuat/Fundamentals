package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class LongestValidParenthesis {

    @Test
    public void canValidateLongestParentheses() {
        assertEquals(2, longestValidParentheses("(()"));
        assertEquals(50, longestValidParentheses("((())()((())())(()((())())())())(())(())()()()))(()()((()))())()))()))(((())((((()))))()()))()()(()(()((())())((())()))))())())((((()(())()))()()(((()()))()"));
        assertEquals(16, longestValidParentheses2("((())()((())())(()((())())())())(())(())()()()))(()()((()))())()))()))(((())((((()))))()()))()()(()(()((())())((())()))))())())((((()(())()))()()(((()()))()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(j);
            } else {
                if (stack.isEmpty()) {
                    left = j;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, j - left);
                    } else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    private boolean isValid(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counter < 0) return false;
            if (s.charAt(i) == ')') counter--;
            else if (s.charAt(i) == '(') counter++;
        }
        return counter == 0;
    }

    private int longestValidParentheses2(String s) {
        int max = 0;
        for (int left = 0, right = s.lastIndexOf(')'); right > left; left++) {
            if (s.charAt(left) == '(') {
                if (isValid(s.substring(left, right - 1))) {
                    max = Math.max(max, right - 1 - left);
                } else {
                    right--;
                    while (s.charAt(right) != ')') {
                        right--;
                    }
                    if (isValid(s.substring(left, right))) {
                        max = Math.max(max, right - left);
                    }
                }
            }
        }
        return max;
    }

}
