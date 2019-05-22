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
        assertEquals("56", -2147483648, myAtoi(""));
    }

    public int myAtoi(String str) {
        str = str.trim();
        boolean progress = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                progress = true;
                if (i == 1 && str.charAt(0) == '-') {
                    sb.append('-');
                }
                sb.append(c);
            } else {
                if (progress) {
                    break;
                } else {
                    return 0;
                }
            }
        }

        long result;
        try
        {
            result = Long.parseLong(sb.toString());
        } catch (
                NumberFormatException e)

        {
            result = Integer.MIN_VALUE;
        }
        return (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE) ? Integer.MIN_VALUE : (int) result;
    }
}
