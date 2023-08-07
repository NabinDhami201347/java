
interface Person {
    void getName(String name);
}

public class Implement implements Person {
    public void getName(String name) {
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
    }

}