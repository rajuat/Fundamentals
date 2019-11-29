package multithreading;

import org.junit.Test;

public class EvenOddPrint {

    @Test
    public void canPrint() {

        Thread even = new Thread(new EvenPrint());
        Thread odd = new Thread(new OddPrint());

        even.start();
        odd.start();
    }

    private class EvenPrint implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i += 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                notifyAll();
            }
        }
    }

    private class OddPrint implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 9; i += 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                notifyAll();
            }
        }
    }

}
