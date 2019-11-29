package queuearray;

public class QueueArrayGenerics<T> {
    private T[] q = null;
    private int capacity = 0;
    int head = 0;
    int tail = 0;
    int currentSize = 0;

    public QueueArrayGenerics(int size){
        this.capacity = size;
        this.q = (T[]) new Object [capacity];
        this.head = 0;
        this.tail = -1;
        this.currentSize = 0;
    }

    public void enqueue(T elem){

        if(currentSize == capacity){
            System.out.println("Queue is full.");
            return;
        }

        tail++;
        if(tail == capacity) {
            tail = 0;
        }
        q[tail] = elem;
        currentSize++;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public T dequeue(){
        if(currentSize == 0){
            System.out.println("Queue is empty");
            return null;
        }

        if(head == capacity){
            head = 0;
        }
        T elem = q[head];
        head++;
        currentSize--;
        return elem;

    }
}


