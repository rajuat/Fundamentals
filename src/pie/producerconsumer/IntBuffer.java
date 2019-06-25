package pie.producerconsumer;

public class IntBuffer {

    private int index = 0;
    private int[] buffer = new int[8];

    public void add(int element){
        while(true){
            if(index < buffer.length){
                buffer[index++] = element;
                return;
            }
        }
    }

    public int delete(){
        while(true){
            if(index > 0){
                return buffer[--index];
            }
        }
    }
}
