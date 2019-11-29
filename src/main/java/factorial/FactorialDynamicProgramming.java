package factorial;

import org.junit.Test;

public class FactorialDynamicProgramming {


    @Test
    public void facTest(){
        long start = System.nanoTime();
        System.out.println(fac(25));
        long end = System.nanoTime();
        System.out.println("Millies: " + (end-start));
    }

    private int fac(int n){
        int[] f = new int[n];

        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i < n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n-1];
    }
}
