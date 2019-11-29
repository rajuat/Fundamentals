package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FruitInBasket {

    @Test
    public void test1() {
        assertEquals(5, totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    @Test
    public void test2() {
        assertEquals(4, totalFruit(new int[]{1, 2, 1, 2, 2}));
    }

    public int totalFruit(int[] tree) {
        int currentCounter = 0;
        int previousCounter = 0;
        int previousPreviousCounter = 0;
        int previousValue = tree[0];
        int previousPreviousValue = 0;
        int ans = 0;
        for (int i = 0; i < tree.length; i++) {
            if (previousValue == tree[i] && i < tree.length - 1) {
                currentCounter++;
            } else {
                if (previousPreviousValue != tree[i]) {
                    ans = Math.max(ans, previousCounter + currentCounter);
                } else {
                    ans = Math.max(ans, previousPreviousCounter + previousCounter + currentCounter);
                }
                previousPreviousValue = previousValue;
                previousPreviousCounter = previousCounter == 0 ? currentCounter : previousCounter;
                previousCounter = currentCounter;
                currentCounter = 1;
            }
            previousValue = tree[i];
        }
        return Math.max(ans, Math.max(currentCounter, previousCounter) + 1);
    }

}
