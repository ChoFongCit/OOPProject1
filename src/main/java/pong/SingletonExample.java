package pong;
import java.io.Serializable;
import java.io.ObjectStreamException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SingletonExample implements Serializable {
    private static final long serialVersionUID = 1L;

    private static SingletonExample instance;

    private String data;

    private SingletonExample() {
        // Private constructor to prevent instantiation
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private Object readResolve() throws ObjectStreamException {
        // Ensure that the singleton instance is maintained after deserialization
        return getInstance();
    }

    public static void saveSingletonInstance(SingletonExample singleton, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(singleton);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SingletonExample loadSingletonInstance(String filename) {
        SingletonExample singleton = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            singleton = (SingletonExample) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonExample singleton = SingletonExample.getInstance();
        singleton.setData("Original Data");

        // Save the singleton instance to a file
        saveSingletonInstance(singleton, "singleton.ser");

        // Reset the singleton instance to null
        singleton = null;

        // Load the singleton instance from the file
        singleton = loadSingletonInstance("singleton.ser");

        // Access the data from the deserialized singleton instance
        System.out.println("Data after deserialization: " + singleton.getData());
    }
}

