package leetcode.google;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesis {
    @Test
    public void test1() {
        assertTrue(isValid("{[()]}"));
        assertTrue(isValid(""));
        assertFalse(isValid("{[()}]"));
        assertFalse(isValid("{"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() < 1) return true;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else if (!stack.isEmpty()) {
                char top = stack.pop();
                if (c == '}' && top != '{' || c == ']' && top != '[' || c == ')' && top != '(') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
