package leetcode;

import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ValidNumber {

    @Test
    public void canMatch(){
        assertTrue("1", isNumber("0"));
        assertTrue("2", isNumber(" 0.1"));
        assertTrue("5", isNumber("2e10"));
        assertTrue("6", isNumber(" -90e3"));
        assertTrue("11", isNumber("53.5e93"));
        assertTrue("9", isNumber(" 6e-1"));
        assertFalse("7", isNumber(" 1e"));
        assertFalse("8", isNumber("e3"));
        assertFalse("10", isNumber(" 99e2.5"));
        assertFalse("3", isNumber("abc"));
        assertFalse("4", isNumber("1 a"));
        assertFalse("12", isNumber(" --6"));
        assertFalse("13", isNumber("-+3"));
        assertFalse("14", isNumber("95a54e53"));
        assertFalse("15", isNumber("95a54"));
        assertTrue("16", isNumber("1 "));
        assertTrue("17", isNumber(".1"));
        assertTrue("18", isNumber("3."));
        assertFalse("19", isNumber(".1."));
    }

    public boolean isNumber(String s) {
        String r1 = "\\s*[-+]?\\.?\\d+(\\.?\\d*)?(e[-+]?\\d+)?\\s*";
        String r = "\\s*[-+]?((\\.?\\d+)|(\\d+\\.?\\d*))(e[-+]?\\d+)?\\s*";
        return Pattern.matches(r, s);
    }
}
