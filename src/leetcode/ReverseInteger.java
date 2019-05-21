package leetcode;

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void canCheckPalindrom() {
        System.out.println(isPalindrome(1_410_110_141));
    }

    public boolean isPalindrome(int x) {
        int divider = 10;
        int counter = 1;
        if (x >= Integer.MAX_VALUE || x < 0) {
            return false;
        }
        while (x % divider != x) {
            counter++;
            divider *= 10;
            if(counter == 10) break;
        }
        for (int i = 1; i <= counter / 2; i++) {
            int left = left(x, counter, i);
            int right = right(x, i);
            System.out.println("L and R values: " + left + " " + right + " " + i);
            if (right != left) {
                return false;
            }
        }
        return true;
    }

    private int left(int x, int counter, int i) {
        int left = (int) (x / Math.pow(10, counter - i));
        System.out.println("L:::" + counter);
        left = (int) (left % 10);
        return left;
    }

    private int right(int x, int i) {
        int right = (int) (x % Math.pow(10, i));
        right = (int) (right / Math.pow(10, i - 1));
        return right;
    }
}
