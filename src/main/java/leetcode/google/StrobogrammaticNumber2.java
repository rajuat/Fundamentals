package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StrobogrammaticNumber2 {

    @Test
    public void printStrobograms() {
        long s = System.nanoTime();
        int c = findStrobogrammatic(5).size();
        System.out.println("Secs: " + (System.nanoTime() - s) / 1000);
        System.out.println("List size: " + c);
        /*s = System.nanoTime();
        findStrobogrammatic2(2);
        System.out.println(System.nanoTime() - s);*/

    }

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        int base = (int) Math.pow(10, n - 1);
        int lowest = n == 1 ? 0 : base + 1;
        int highest = (int) Math.pow(10, n);
        int count = 0;
        int s = 0;
        for (int i = lowest; i < highest; ) {
            count++;
            String num = String.valueOf(i);
            if (isStrobogrammatic(num)) {
                //System.out.println(num);
                res.add(num);
            }
            int start = i;
            for (int j = 1; j < base; j = j * 10) {
                i = skips(base / j, i);
            }
            i = unitPlaceSkip(i);
            s = s + i - start;
        }
        System.out.println("Skips: " + s);
        System.out.println("Count: " + count);
        return res;
    }

    private int skips(int base, int i) {
        if (base < 10) return i;
        int digit = i / base;
        int lastNumber = ((digit + 1) * base) - 1;
        digit = digit % 10;
        if (digit == 1 && i == lastNumber) {
            i = i + 1 + 4 * base;
        } else if (digit == 6 && i == lastNumber) {
            i = i + 1 + base;
        }
        //return i;
        return skips(base / 10, i);
    }

    private int unitPlaceSkip(int digit) {
        int unitDigit = digit % 10;
        if (unitDigit == 1) {
            digit = digit + 5;
        } else if (unitDigit == 6) {
            digit = digit + 2;
        } else {
            digit++;
        }
        return digit;
    }

    private boolean isStrobogrammatic(String num) {
        char[] number = num.toCharArray();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = number[i];
            if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7') {
                return false;
            }
            if (c == '6' && number[n - 1 - i] != '9') {
                return false;
            }
            if (c == '9' && number[n - 1 - i] != '6') {
                return false;
            }
            if (c == '0' && number[n - 1 - i] != '0') {
                return false;
            }
            if (c == '1' && number[n - 1 - i] != '1') {
                return false;
            }
            if (c == '8' && number[n - 1 - i] != '8') {
                return false;
            }
        }
        return true;
    }

    public List<String> findStrobogrammatic2(int n) {
        List<String> res = new ArrayList<>();
        int base = (int) Math.pow(10, n - 1);
        int lowest = n == 1 ? 0 : base + 1;
        int highest = (int) Math.pow(10, n);
        for (int i = lowest; i < highest; i++) {
            String num = String.valueOf(i);
            if (isStrobogrammatic(num)) {
                //System.out.println(num);
                res.add(num);
            }
        }
        return res;
    }

    private int skip(int tens, int i) {
         /*for (int j = 0; j < n; j++) {
                int tens = (int) (base / Math.pow(10, j));
                i = skip(tens, i);
                System.out.println("i: " + i);
            }*/
        int digit = i / tens;
        int lastNumber = ((digit + 1) * tens) - 1;
        if (i == lastNumber) {
            digit = digit % 10;
            if (digit == 1) {
                i = i + 1 + 4 * tens;
            } else if (digit == 6) {
                i = i + 1 + tens;
            }
        }
        return i;
    }
}
