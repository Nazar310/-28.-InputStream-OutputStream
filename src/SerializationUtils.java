import java.io.*;

public class SerializationUtils {

    public static void serializeObject(String filename, Serializable object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
