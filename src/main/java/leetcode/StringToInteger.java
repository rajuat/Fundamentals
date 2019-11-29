package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToInteger {

    @Test
    public void canConvert() {
        assertEquals("3", 4193, myAtoi("4193 with words"));
        assertEquals("4", 0, myAtoi("words and 987"));
        assertEquals("1", 42, myAtoi("42"));
        assertEquals("2", -42, myAtoi("   -42"));
        assertEquals("5", -2147483648, myAtoi("-91283472332"));
        assertEquals("6", 0, myAtoi(""));
        assertEquals("7", 1, myAtoi("+1"));
        assertEquals("8", 2147483647, myAtoi("2147483647"));
        assertEquals("9", 2147483647, myAtoi("2147483648"));
        assertEquals("10", 2147483647, myAtoi("20000000000000000000"));
        assertEquals("11", 0, myAtoi("+"));
        assertEquals("12", 0, myAtoi("-"));
        assertEquals("13", -2147483648, myAtoi("-9223372036854775809"));
    }

    public int myAtoi(String str) {
        double result;
        str = str.trim();
        boolean digitsFound = false;
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        if (str.length() > 0) {
            char c = str.charAt(0);
            if (c == '-') {
                if (str.length() == 1) return 0;
                sb.append('-');
                counter++;
            } else if (c == '+') {
                if (str.length() == 1) return 0;
                counter++;
            }
        } else {
            return 0;
        }
        for (int i = counter; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digitsFound = true;
                sb.append(c);
            } else {
                if (digitsFound) {
                    break;
                } else {
                    return 0;
                }
            }
        }

        try {
            result = Double.parseDouble(sb.toString());
            //result = Long.parseLong(sb.toString());
        } catch (NumberFormatException e) {
            result = Integer.MAX_VALUE;
        }
        if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE) result = Integer.MIN_VALUE;
        return (int) result;
    }
}
