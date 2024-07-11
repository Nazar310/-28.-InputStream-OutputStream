import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок тексту: ");
        String userInput = scanner.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(userInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Вміст файлу output.txt: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("source.txt")) {
            writer.write("Це текст для файлу source.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("source.txt"))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            try (FileWriter writer = new FileWriter("destination.txt")) {
                writer.write(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyClass myObject = new MyClass("Приклад тексту", 123);
        SerializationUtils.serializeObject("object.ser", myObject);
        MyClass deserializedObject = (MyClass) SerializationUtils.deserializeObject("object.ser");
        System.out.println("Десеріалізований об'єкт: " + deserializedObject);
    }
}
