package techdevguide;

import org.junit.Test;
import queuearray.QueueArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class IteratorFlatenner {

    @Test public void canInterleave(){
        IF iflat = new IF(iterlist);
        while(iflat.hasNext){
            System.out.println(iflat.next());
        }
    }


    Integer[] arr1 = {1, 2, 3};
    Integer[] arr2 = {4, 5};
    Integer[] arr3 = {6, 7, 8, 9};

    Iterator<Integer> a = Arrays.asList(arr1).iterator();
    Iterator<Integer> b = Arrays.asList(arr2).iterator();
    Iterator<Integer> c = Arrays.asList(arr3).iterator();

    Iterator<Integer>[] iterlist = new Iterator[]{a, b, c};

    class IF implements Iterator<Integer> {

        private Iterator<Integer>[] iterlist;
        private boolean hasNext = false;
        PriorityQueue<Iterator<Integer>> queue = null;

        public IF(Iterator<Integer>[] iterlist) {
            this.iterlist = iterlist;
            this.queue = new PriorityQueue();
            for (int i = 0; i < iterlist.length; i++) {
                Iterator<Integer> e = iterlist[i];
                if (e.hasNext()){
                    hasNext = true;
                }
                queue.add(e);
            }
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public Integer next() {
            Integer next = null;
            Iterator<Integer> poll = queue.poll();
            if (poll != null) {
                next = poll.next();
                if (poll.hasNext()) {
                    queue.add(poll);
                }
            } else {
                hasNext = false;
            }

            return next;
        }
    }

}
