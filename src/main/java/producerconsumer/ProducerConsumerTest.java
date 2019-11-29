package pie.producerconsumer;

import org.junit.Test;

public class ProducerConsumerTest {
    @Test
    public void canCheckPC(){
        IntBuffer buffer = new IntBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

    }
}
