package leetcode.google;

import org.junit.Test;

import java.util.List;

public class AutocompleteSystemTest {
    @Test
    public void printSearch() {
        String[] sens = new String[]{
                "i love you",
                "island",
                "ironman",
                "i love leetcode"
        };
        int[] times = new int[]{
                5,
                3,
                2,
                2
        };
        AutocompleteSystem search = new AutocompleteSystem(sens, times);
        List<String> ss = search.input('i');
        for(String s: ss){
            System.out.println(s);
        }
        System.out.println("------------");

        List<String> ss1 = search.input(' ');
        for(String s: ss1){

            System.out.println(s);
        }
    }
}
