package factorial;

import org.junit.Test;

public class FactorialRecursion {

    @Test
    public void fac(){
        long start = System.nanoTime();
        System.out.println(f(25));
        long end = System.nanoTime();
        System.out.println("Millies: " + (end-start));
    }

    private int f(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }

        return f(n-1) + f(n-2);
    }
}
