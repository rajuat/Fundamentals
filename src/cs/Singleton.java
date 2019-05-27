package cs;


import java.io.*;

public class Singleton implements Serializable {
    public Object readResolve(){
        return getInstance();
    }

    int state = 0;
    private Singleton(){
        this.state++;
    }
    public void useMeMethod(String msg) {
        System.out.println(System.currentTimeMillis() + ": " + msg);
    }

    // Inner class initializes instance on load, won't be loaded until referenced by getInstance()
    private static class SingletonHolder {
        public static final Singleton instance = new Singleton();
    }

    // Return the singleton instance.
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    /*// Popular way of creating singleton
    private static Singleton instance1 = null;
    private Singleton() {
    }
    public static Singleton getInstance1() {
        if (instance1 == null) {
            instance1 = new Singleton();
        }
        return instance1;
    }*/

    public static void main(String[] args) {
        System.out.println(getInstance().state);
        System.out.println(getInstance().state);
        System.out.println(getInstance().state);
        System.out.println(getInstance().state);
        System.out.println(getInstance().state);

        SingletonBreaker sb = new SingletonBreaker();
        sb.breakSingleton();

    }

}

class SingletonBreaker {

    Singleton singleton = Singleton.getInstance();


    public void breakSingleton()
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
            oos.writeObject(singleton);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Singleton second = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
            second = (Singleton) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("First Object : " + singleton);
        System.out.println("Second Object : " + second);
    }

}
