package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Logger {
    @Test
    public void canDeterminedPrints() {
        Logger logger = new Logger();

        assertTrue(logger.shouldPrintMessage(1, "foo"));
        assertTrue(logger.shouldPrintMessage(2, "bar"));
        assertFalse(logger.shouldPrintMessage(3, "foo"));
        assertFalse(logger.shouldPrintMessage(8, "bar"));
        assertFalse(logger.shouldPrintMessage(10, "foo"));
        assertTrue(logger.shouldPrintMessage(11, "foo"));
        assertFalse(logger.shouldPrintMessage(3, "foo"));
        assertTrue(logger.shouldPrintMessage(21, "foo"));
    }


    private Map<String, Integer> lastPrinted = null;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        lastPrinted = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer i = lastPrinted.get(message);
        if (i == null) {
            lastPrinted.put(message, timestamp);
            return true;
        }
        if (timestamp - i >= 10) {
            lastPrinted.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */