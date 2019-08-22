package leetcode.google;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class DecodeString {
    @Test
    public void test1() {
        assertEquals("aaabcbc", decode("3[a]2[bc]"));
    }

    @Test
    public void test2() {
        assertEquals("accaccacc", decode("3[a2[c]]"));
    }

    @Test
    public void test3() {
        assertEquals("abcabccdcdcdef", decode("2[abc]3[cd]ef"));
    }

    public String decode(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                String word = sb.reverse().toString();
                stack.pop();
                int count = 0;
                int mul = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count = count + Character.getNumericValue(stack.pop()) * mul;
                    mul *= 10;
                }
                if (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    for (int i = 0; i < count; i++) {
                        for (char ch : word.toCharArray())
                            stack.add(ch);
                    }
                } else for (int i = 0; i < count; i++) {
                    ans.append(word);
                }

            } else {
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        ans.append(sb.reverse().toString());
        return ans.toString();
    }


}
