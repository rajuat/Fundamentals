package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {



    public List<String> fizzBuzz(int n) {
        List<String> numbers = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if(i % 15 == 0){
                numbers.add("FizzBuzz");
            } else if(i % 3 == 0) {
                numbers.add("Fizz");
            } else if(i % 5 == 0){
                numbers.add("Buzz");
            } else {
                numbers.add(""+i);
            }
        }
        return numbers;
    }
}
