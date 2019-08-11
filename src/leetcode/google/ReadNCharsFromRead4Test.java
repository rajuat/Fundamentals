package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadNCharsFromRead4Test {
    @Test
    public void reading5and3From6(){
        ReadNCharsFromRead4 o = new ReadNCharsFromRead4("abcdef");
        char[] b1 = new char[5];
        int c = o.read(b1, 5);
        assertEquals(5, c);
        assertEquals( "abcde", String.valueOf(b1));
        char[] b2 = new char[1];
        int c2 = o.read(b2, 3);
        assertEquals(1, c2);
        assertEquals( "f", String.valueOf(b2));
    }

    @Test
    public void reading121From3(){
        ReadNCharsFromRead4 o = new ReadNCharsFromRead4("abc");
        char[] b1 = new char[1];
        int c = o.read(b1, 1);
        assertEquals(1, c);
        assertEquals( "a", String.valueOf(b1));
        char[] b2 = new char[2];
        int c2 = o.read(b2, 2);
        assertEquals(2, c2);
        assertEquals( "bc", String.valueOf(b2));
        char[] b3 = new char[1];
        int c3 = o.read(b3, 1);
        assertEquals(0, c3);
    }

    @Test
    public void reading41From3(){
        ReadNCharsFromRead4 o = new ReadNCharsFromRead4("abc");
        char[] b1 = new char[4];
        int c = o.read(b1, 4);
        assertEquals(3, c);
        char[] b2 = new char[1];
        int c2 = o.read(b2, 1);
        assertEquals(0, c2);
    }

    @Test
    public void reading14From5(){
        ReadNCharsFromRead4 o = new ReadNCharsFromRead4("abcde");
        char[] b1 = new char[1];
        int c = o.read(b1, 1);
        assertEquals(1, c);
        char[] b2 = new char[4];
        int c2 = o.read(b2, 4);
        assertEquals(4, c2);
    }

    @Test
    public void reading9614(){
        ReadNCharsFromRead4 o = new ReadNCharsFromRead4("WRBqHdrOkyIDsdRMwRSYLBfaCYEdgxPlrlNppfkOKcqNnuwSmbUcJISmKtXxvRBJTSFzfMfdRsfbnvhFSqWQaeCZFKlOJppRXiZx");
        char[] b1 = new char[96];
        int c = o.read(b1, 96);
        assertEquals(96, c);
        char[] b2 = new char[1];
        int c2 = o.read(b2, 1);
        assertEquals(1, c2);
        char[] b3 = new char[4];
        int c3 = o.read(b3, 4);
        assertEquals(3, c3);
        System.out.println(String.valueOf(b3));
    }
}
