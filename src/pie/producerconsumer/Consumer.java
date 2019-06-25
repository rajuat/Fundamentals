package pie.producerconsumer;

public class Consumer extends Thread {

    private IntBuffer buffer;

    public Consumer(IntBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        while(true){
            int num = this.buffer.delete();
            System.out.println("Consume: " + num);
        }
    }
}
