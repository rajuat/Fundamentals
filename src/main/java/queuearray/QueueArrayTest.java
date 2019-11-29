package queuearray;

import org.junit.Test;

public class QueueArrayTest {

    @Test
    public void canQueue(){
        QueueArray queueArray = new QueueArray(3);
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.enqueue(5);

        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Dequeue: " + queueArray.dequeue());
    }
}
