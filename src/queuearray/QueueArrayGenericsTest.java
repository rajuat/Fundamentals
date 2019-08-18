package queuearray;

import org.junit.Test;

public class QueueArrayGenericsTest {

    @Test
    public void canQueue(){
        QueueArrayGenerics<String> queueArray = new QueueArrayGenerics(3);
        queueArray.enqueue("one");
        queueArray.enqueue("two");
        queueArray.enqueue("three");
        queueArray.enqueue("four");
        queueArray.enqueue("five");

        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Dequeue: " + queueArray.dequeue());
    }
}
