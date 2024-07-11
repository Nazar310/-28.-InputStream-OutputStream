import java.io.Serializable;

public class MyClass implements Serializable {
    private String text;
    private int number;

    public MyClass(String text, int number) {
        this.text = text;
        this.number = number;
    }

    @Override
    public String toString() {
        return "MyClass{text='" + text + "', number=" + number + "}";
    }
}
