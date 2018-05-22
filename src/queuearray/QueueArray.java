package queuearray;

import org.junit.Test;

public class QueueArray {
    private int[] q = null;
    private int capacity = 0;
    int head = 0;
    int tail = 0;
    int currentSize = 0;

    public QueueArray(int size){
        this.capacity = size;
        this.q = new int [capacity];
        this.head = 0;
        this.tail = -1;
        this.currentSize = 0;
    }

    public void enqueue(int elem){

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

    public int dequeue(){
        if(currentSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }

        if(head == capacity){
            head = 0;
        }
        int elem = q[head];
        head++;
        currentSize--;
        return elem;

    }
}


